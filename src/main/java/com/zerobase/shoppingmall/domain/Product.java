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
    private Long product_id;

    private String product_name;

    private Long price;

    private String product_explanation;

    private int stock;

    private String seller;

    private Long sales_volume;

}
