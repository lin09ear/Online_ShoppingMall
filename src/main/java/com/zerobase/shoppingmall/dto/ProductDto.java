package com.zerobase.shoppingmall.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Long id;

    private String name;

    private Long price;

    private String explanation;

    private Integer stock;

    private Boolean isSoldout;

    private String seller;

    private Long salesVolume;
}
