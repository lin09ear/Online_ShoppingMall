package com.zerobase.shoppingmall.dto;

import com.zerobase.shoppingmall.domain.Cart;
import com.zerobase.shoppingmall.domain.CartItem;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDto {

    private Long cartId;

    private Map<Long, CartItem> cartItems;

    public static CartDto fromEntity(Cart cart) {
        return CartDto.builder()
                .cartId(cart.getCartId())
                .cartItems(cart.getCartItems())
                .build();
    }
}
