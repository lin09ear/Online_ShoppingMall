package com.zerobase.shoppingmall.controller;

import com.zerobase.shoppingmall.domain.Cart;
import com.zerobase.shoppingmall.domain.CartItem;
import com.zerobase.shoppingmall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/create/cart")
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.createCart(cart);
    }

    @PostMapping("/add/{cartId}/items")
    public void addProductToCart(@PathVariable Long cartId, @RequestBody CartItem cartItem) {
        cartService.addProductToCart(cartId, cartItem.getProductId(), cartItem.getQuantity());
    }

}
