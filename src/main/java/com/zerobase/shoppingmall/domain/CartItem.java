package com.zerobase.shoppingmall.domain;

import com.zerobase.shoppingmall.dto.CreateCart;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CartItem extends CreateCart {

    @Id
    @GeneratedValue
    private Long id;
    private Long cartId;
    private Long productId;
    private Integer count;
    private Long price;

    private Integer stock;

    private String name;

    public static CartItem createCartItem(Long cartId, Long productId, int count) {
        CartItem cartItem = new CartItem();
        cartItem.setCartId(cartItem.cartId);
        cartItem.setProductId(cartItem.productId);
        cartItem.setCount(count);
        cartItem.setStock(cartItem.stock);
        return cartItem;
    }

    public void addCount(int count){
        this.count += count;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }
}
