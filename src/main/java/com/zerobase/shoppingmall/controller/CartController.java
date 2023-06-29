package com.zerobase.shoppingmall.controller;

import com.zerobase.shoppingmall.domain.Cart;
import com.zerobase.shoppingmall.domain.CartItem;
import com.zerobase.shoppingmall.dto.CreateCart;
import com.zerobase.shoppingmall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

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

    @PostMapping("/cart/{cartId}/additem")
    public void addProductToCart(@PathVariable Long cartId, @RequestBody CartItem cartItem) {
        cartService.addProductToCart(cartId, cartItem.getProductId(), cartItem.getQuantity());
    }

}
