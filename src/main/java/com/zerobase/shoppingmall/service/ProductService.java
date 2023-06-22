package com.zerobase.shoppingmall.service;

import com.zerobase.shoppingmall.domain.Product;
import com.zerobase.shoppingmall.dto.ProductDto;
import lombok.AllArgsConstructor;
import com.zerobase.shoppingmall.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.apache.commons.collections4.Trie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final Trie trie;
    private ProductRepository productRepository;

    /**
     * 상품 등록
     * 상품 리스트 조회 - 페이지 방식
     * 상품 조회 자동완성
     * 상품 상세 조회
     */


    public Page<Product> getAllProduct(Pageable pageable){
        return this.productRepository.findAll(pageable);
    }

    public void addAutocompleteKeyword(String keyword){
        this.trie.put(keyword, null);
    }

    public List<String> autocomplete(String keyword){
        return (List<String>) this.trie.prefixMap(keyword).keySet()
                .stream()
                .limit(10)
                .collect(Collectors.toList());
    }

    public void deleteAutocompleteKeyword(String keyword){
        this.trie.remove(keyword);
    }



}
