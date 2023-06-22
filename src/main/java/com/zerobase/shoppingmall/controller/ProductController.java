package com.zerobase.shoppingmall.controller;

import com.zerobase.shoppingmall.domain.Product;
import com.zerobase.shoppingmall.dto.ProductDto;
import com.zerobase.shoppingmall.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/autocomplete")
    public ResponseEntity<?> autocomplete(@RequestParam String keyword) {
        var result = this.productService.autocomplete(keyword);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/list")
    public ResponseEntity<?> searchProduct(final Pageable pageable){
        Page<Product> products = this.productService.getAllProduct(pageable);
        return ResponseEntity.ok(products);

    }
}
