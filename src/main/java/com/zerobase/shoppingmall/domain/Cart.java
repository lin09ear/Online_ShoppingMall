package com.zerobase.shoppingmall.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private Long id;

    @OneToMany
    private Map<Long, CartItem> cartItems = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCartItems(Map<Long, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addProduct(Long productId, Integer quantity) {
        if (!cartItems.containsKey(productId)) {
            cartItems.put(productId, new CartItem());
        } else {
            cartItems.get(productId).setQuantity(cartItems.get(productId).getQuantity() + quantity);
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
            total += cartItem.getPrice() * cartItem.getQuantity();
        }
        return total;
    }

}
