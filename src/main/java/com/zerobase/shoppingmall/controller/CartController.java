package com.zerobase.shoppingmall.controller;

import com.zerobase.shoppingmall.domain.Cart;
import com.zerobase.shoppingmall.domain.CartItem;
import com.zerobase.shoppingmall.dto.CartDto;
import com.zerobase.shoppingmall.dto.CreateCart;
import com.zerobase.shoppingmall.exception.BadRequestException;
import com.zerobase.shoppingmall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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


    @PostMapping("/additem/{cartId}")
    public void addProductToCart(@PathVariable Long cartId, @RequestBody CartItem cartItem) {
        if (cartItem == null) {
            throw new BadRequestException("Invalid request body.");
        }

        cartService.addProductToCart(cartId, cartItem.getProductId(), cartItem.getCount());
    }


}
