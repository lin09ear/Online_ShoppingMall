package com.zerobase.shoppingmall.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Long price;

    private String explanation;

    private Integer stock;

    private Boolean isSoldout;

    private String seller;

    private Long salesVolume;


}
