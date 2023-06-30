package com.zerobase.shoppingmall.controller;

import com.zerobase.shoppingmall.domain.Product;
import com.zerobase.shoppingmall.dto.CreateCart;
import com.zerobase.shoppingmall.dto.CreateProduct;
import com.zerobase.shoppingmall.dto.ProductDto;
import com.zerobase.shoppingmall.dto.ProductRegistrationDto;
import com.zerobase.shoppingmall.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/create")
    public CreateProduct.Response createProduct(
            @RequestBody @Valid CreateProduct.Request request
    ) {
        ProductDto productDto = new ProductDto();
        productDto.setId(request.getId());
        productDto.setName(request.getName());
        productDto.setPrice(request.getPrice());
        productDto.setExplanation(request.getExplanation());
        productDto.setSeller(request.getSeller());

        return CreateProduct.Response.from(productService.createProduct(
                productDto.getId(),
                productDto.getName(),
                productDto.getPrice(),
                productDto.getExplanation(),
                productDto.getSeller()
        ));
    }


    @GetMapping("/product/list")
    public Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
