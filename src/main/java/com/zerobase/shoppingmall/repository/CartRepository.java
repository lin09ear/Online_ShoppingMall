package com.zerobase.shoppingmall.repository;

import com.zerobase.shoppingmall.domain.Cart;
import com.zerobase.shoppingmall.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Product findAllByCartId(Long cartId);

}
