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
public class Basket {


    @Id
    @GeneratedValue
    private Long basket_id;

    private Long user_id;

    private Long product_id;
    private int number_of_orders;

}
