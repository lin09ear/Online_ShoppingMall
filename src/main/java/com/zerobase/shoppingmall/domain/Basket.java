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
    private Long basketId;

    private Long userId;

    private Long productId;
    private Integer orderCount;

}
