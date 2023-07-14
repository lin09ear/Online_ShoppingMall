package com.zerobase.shoppingmall.service;

import com.zerobase.shoppingmall.config.HibernateUtil;
import com.zerobase.shoppingmall.domain.Cart;
import com.zerobase.shoppingmall.domain.CartItem;
import com.zerobase.shoppingmall.domain.Product;
import com.zerobase.shoppingmall.dto.CartDto;
import com.zerobase.shoppingmall.dto.CartItemDto;
import com.zerobase.shoppingmall.dto.ProductDto;
import com.zerobase.shoppingmall.exception.ResourceNotFoundException;
import com.zerobase.shoppingmall.repository.CartItemRepository;
import com.zerobase.shoppingmall.repository.CartRepository;
import com.zerobase.shoppingmall.repository.ProductRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;


    @Transactional
    public CartDto createCart(Long cartId) {
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

    @Transactional
    public Map<Long, CartItem> getCartItems(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found with id: " + cartId));

        Map<Long, CartItem> cartItems = new HashMap<>();

        // Get the product names and prices from the database.
        List<CartItem> cartItemList = cartItemRepository.findByCartId(cartId);

        for (CartItem cartItem : cartItemList) {
            cartItems.put(cartItem.getProductId(), cartItem);
        }

        return cartItems;
    }



    public void addProductToCart(Long cartId, Long productId, int count) {

        // Get the cart.
        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        Cart cart = cartOptional.orElseThrow(() -> new EntityNotFoundException("Cart not found"));

        // Get the product.
        Product product = productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException("Product not found"));

        // Get the CartItem.
        CartItem cartItem = cart.getCartItems().get(productId);
        if (cartItem != null) {
            // Update the CartItem's count.
            cartItem.setCount(cartItem.getCount() + count);
            cartItem.setPrice(cartItem.getPrice() + product.getPrice() * count);
        } else {
            // Create a new CartItem.
            cartItem = new CartItem();
            cartItem.setCartId(cartId);
            cartItem.setProductId(product.getProductId());
            cartItem.setCount(count);
            cartItem.setPrice(product.getPrice() * count);
            cartItem.setName(product.getName());
            cartItem.setStock(product.getStock());
        }
        cartItemRepository.save(cartItem);

        // Add the CartItem to the cart's cartItems map.
        cart.getCartItems().put(productId, cartItem);

        // Save the cart and the CartItem.
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
