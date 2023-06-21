package com.zerobase.shoppingmall.service;

import com.zerobase.shoppingmall.domain.Product;
import lombok.AllArgsConstructor;
import com.zerobase.shoppingmall.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public Page<Product> getAllProduct(Pageable pageable){
        return this.productRepository.findAll(pageable);
    }

}
