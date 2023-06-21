package com.zerobase.shoppingmall.dto;

import com.zerobase.shoppingmall.domain.Product;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductRegistrationDto {

    private Long id;

    @NotBlank(message = "상품명은 필수 입력 값입니다.")
    private String name;

    @NotNull(message = "가격은 필수 입력 값입니다.")
    private Long price;

    private String explanation;

    @NotNull(message = "재고는 필수 입력 값입니다.")
    private Integer stock;

    private String seller;

    public Product createProduct(){
        Product product = Product.builder()
                .name(name)
                .price(price)
                .explanation(explanation)
                .stock(stock)
                .seller(seller)
                .build();
        return product;
    }

}
