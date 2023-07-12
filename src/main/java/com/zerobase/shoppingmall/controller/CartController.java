package com.zerobase.shoppingmall.controller;

import com.zerobase.shoppingmall.domain.Cart;
import com.zerobase.shoppingmall.domain.CartItem;
import com.zerobase.shoppingmall.dto.CartDto;
import com.zerobase.shoppingmall.dto.CreateCart;
import com.zerobase.shoppingmall.repository.CartRepository;
import com.zerobase.shoppingmall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;

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


}
