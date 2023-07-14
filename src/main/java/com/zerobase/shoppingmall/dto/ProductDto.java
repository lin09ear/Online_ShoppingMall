package com.zerobase.shoppingmall.dto;

import com.zerobase.shoppingmall.domain.Product;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long productId;

    private String name;

    private Long price;

    private String explanation;

    private Boolean isSoldout;

    private String seller;

    private Long salesVolume;

    private Integer stock;

    public static ProductDto fromEntity(Product product){
        return ProductDto.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .price(product.getPrice())
                .explanation(product.getExplanation())
                .isSoldout(product.getIsSoldout())
                .seller(product.getSeller())
                .salesVolume(product.getSalesVolume())
                .stock(product.getStock())
                .build();
    }
}
