package com.zerobase.shoppingmall.service;

import com.zerobase.shoppingmall.config.HibernateUtil;
import com.zerobase.shoppingmall.domain.Cart;
import com.zerobase.shoppingmall.domain.CartItem;
import com.zerobase.shoppingmall.domain.Product;
import com.zerobase.shoppingmall.dto.CartDto;
import com.zerobase.shoppingmall.dto.CartItemDto;
import com.zerobase.shoppingmall.dto.ProductDto;
import com.zerobase.shoppingmall.repository.CartItemRepository;
import com.zerobase.shoppingmall.repository.CartRepository;
import com.zerobase.shoppingmall.repository.ProductRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public CartDto createCart(Long id) {
/*
        Long newCartId = cartRepository.findFirstByOrderByIdDesc()
                .map(cart -> cart.getId() + 1)
                .orElse(10000L);
*/
        return CartDto.fromEntity(
                cartRepository.save(Cart.builder()
                        .build())
        );
    }

    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }


    public void addProductToCart(Long cartId, Long productId, int count) {
        // Get the cart.
        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        Cart cart = cartOptional.orElseThrow(EntityNotFoundException::new);

        // Get the CartItem object.
        CartItem cartItem = cartItemRepository.findByCartIdAndProductId(cartId, productId);

        // If the CartItem object is not null, then increase the quantity.
        if (cartItem != null) {
            cartItem.setCount(cartItem.getCount() + count);
        } else {

            // If the CartItem object is null, then create a new one.
            cartItem = CartItem.builder()
                    .cartId(cartId)
                    .productId(productId)
                    .count(count)
                    .build();
        }

        // Save the CartItem object.
        cartItemRepository.save(cartItem);

        // Save the cart.
        cartRepository.save(cart);
    }

    public void removeProductFromCart(Long cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        Product product = productRepository.findById(productId).orElse(null);
        cart.removeProduct(productId);
        cartRepository.save(cart);
    }

    public void emptyCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        cart.emptyCart();
        cartRepository.save(cart);
    }

    public Long getCartTotal(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        return cart.getCartTotal();
    }

}
