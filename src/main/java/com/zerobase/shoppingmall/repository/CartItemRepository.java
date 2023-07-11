package com.zerobase.shoppingmall.repository;

import com.zerobase.shoppingmall.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByCartIdAndProductId(Long cartId, Long productId);
}
