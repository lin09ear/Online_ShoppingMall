package com.zerobase.shoppingmall.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemDto {

    private Long cartId;
    private Long productId;
    private int count;

    public CartItemDto(Long cartId, Long productId, int count) {
        this.cartId = cartId;
        this.productId = productId;
        this.count = count;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
