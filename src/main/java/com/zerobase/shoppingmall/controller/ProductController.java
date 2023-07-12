package com.zerobase.shoppingmall.controller;

import com.zerobase.shoppingmall.domain.Product;
import com.zerobase.shoppingmall.dto.CreateProduct;
import com.zerobase.shoppingmall.dto.ProductDto;
import com.zerobase.shoppingmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/create")
    public CreateProduct.Response createProduct(
            @RequestBody @Valid CreateProduct.Request request
    ) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(request.getProductId());
        productDto.setName(request.getName());
        productDto.setPrice(request.getPrice());
        productDto.setExplanation(request.getExplanation());
        productDto.setSeller(request.getSeller());

        return CreateProduct.Response.from(productService.createProduct(
                productDto.getProductId(),
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
