package com.zerobase.shoppingmall.dto;

import com.zerobase.shoppingmall.domain.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemDto {

    private Long cartId;
    private Long productId;
    private Integer count;
    private Long price;

    private Integer stock;

    public CartItemDto(Long cartId, Long productId, Integer count, Integer stock) {
        this.cartId = cartId;
        this.productId = productId;
        this.count = count;
        this.stock = stock;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
