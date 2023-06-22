package com.zerobase.shoppingmall.repository;

import com.zerobase.shoppingmall.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findAllById(Long id);

    Optional<Product> findByName(String name);

    Page<Product> findByNameStartingWithIgnoreCase(String s, Pageable pageable);
}
