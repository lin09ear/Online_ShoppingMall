package com.zerobase.shoppingmall.domain;

import com.zerobase.shoppingmall.dto.ProductDto;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.stream.DoubleStream;

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

  /*  public Product(Product product){
        this.name = product.getName();
    }
*/
}
