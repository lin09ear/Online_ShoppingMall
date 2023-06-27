package com.zerobase.shoppingmall.repository;

import com.zerobase.shoppingmall.domain.Cart;
import com.zerobase.shoppingmall.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
