package com.zerobase.shoppingmall.dto;

import com.zerobase.shoppingmall.domain.Product;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {


    private Long id;

    private String name;

    private Long price;

    private String explanation;

    private Boolean isSoldout;

    private String seller;

    private Long salesVolume;

    public static ProductDto fromEntity(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .explanation(product.getExplanation())
                .isSoldout(product.getIsSoldout())
                .seller(product.getSeller())
                .salesVolume(product.getSalesVolume())
                .build();
    }
}
