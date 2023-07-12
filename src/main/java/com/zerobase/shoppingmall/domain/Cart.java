package com.zerobase.shoppingmall.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Cart {

    @Id
    @GeneratedValue
    private Long cartId;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "cartId")
    private Map<Long, CartItem> cartItems = new HashMap<>();

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public void setCartItems(Map<Long, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addProduct(Long productId, Integer count) {
        if (!cartItems.containsKey(productId)) {
            cartItems.put(productId, new CartItem());
        } else {
            cartItems.get(productId).setCount(cartItems.get(productId).getCount() + count);
        }
    }

    public void removeProduct(Long productId) {
        cartItems.remove(productId);
    }

    public void emptyCart() {
        cartItems.clear();
    }

    public Long getCartTotal() {
        Long total = 0L;
        for (CartItem cartItem : cartItems.values()) {
            total += cartItem.getPrice() * cartItem.getCount();
        }
        return total;
    }

}
