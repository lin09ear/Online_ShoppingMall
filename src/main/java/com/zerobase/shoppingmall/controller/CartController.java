package com.zerobase.shoppingmall.controller;

import com.zerobase.shoppingmall.domain.Cart;
import com.zerobase.shoppingmall.domain.CartItem;
import com.zerobase.shoppingmall.domain.Product;
import com.zerobase.shoppingmall.dto.CartDto;
import com.zerobase.shoppingmall.dto.CreateCart;
import com.zerobase.shoppingmall.exception.ResourceNotFoundException;
import com.zerobase.shoppingmall.repository.CartItemRepository;
import com.zerobase.shoppingmall.repository.CartRepository;
import com.zerobase.shoppingmall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @PostMapping("/cart/create")
    public CreateCart.Response createCart(
            @RequestBody @Valid CreateCart.Request request
    ) {
        return CreateCart.Response.from(
                cartService.createCart(
                        request.getId()
                )
        );
    }

    @Transactional
    @PostMapping("/additem/{cartId}")
    public void addProductToCart(@PathVariable Long cartId, @RequestBody CartItem cartItem) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new EntityNotFoundException("Cart not found"));
        Long productId = cartItem.getProductId();
        cartService.addProductToCart(cartId, productId, cartItem.getCount());
        cartRepository.save(cart);
    }
    
    @Transactional
    @GetMapping("/cart/{cartId}")
    public Map<Long, CartItem> getCartItems(@PathVariable Long cartId) {
        return cartService.getCartItems(cartId);
    }
}
