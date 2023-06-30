package com.zerobase.shoppingmall.service;

import com.zerobase.shoppingmall.domain.Product;
import com.zerobase.shoppingmall.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;

@Service
public class ProductService {

    public Page<Product> getAllProduct(Pageable pageable){
        return this.productRepository.findAll(pageable);
    }

    @Autowired
    private JpaRepository<Product, Long> productRepository;

    private ProductDto productDto;


    @Transactional
    public ProductDto createProduct(Long id, String name, Long price, String explanation, String seller) {
        Product product = Product.builder()
                .id(id)
                .name(name)
                .price(price)
                .explanation(explanation)
                .seller(seller)
                .build();

        Product savedProduct = productRepository.save(product);
        return ProductDto.fromEntity(savedProduct);
    }


    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
