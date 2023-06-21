package com.zerobase.shoppingmall.repository;

import com.zerobase.shoppingmall.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findAllById(Long id);
}
