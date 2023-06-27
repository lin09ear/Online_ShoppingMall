package com.zerobase.shoppingmall.service;

import com.zerobase.shoppingmall.domain.Product;
import com.zerobase.shoppingmall.dto.ProductDto;
import lombok.AllArgsConstructor;
import com.zerobase.shoppingmall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.apache.commons.collections4.Trie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    public Page<Product> getAllProduct(Pageable pageable){
        return this.productRepository.findAll(pageable);
    }

    @Autowired
    private JpaRepository<Product, Long> productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
