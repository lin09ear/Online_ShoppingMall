package com.zerobase.shoppingmall.dto;

import com.zerobase.shoppingmall.domain.CartItem;
import com.zerobase.shoppingmall.domain.Product;
import lombok.*;

import javax.validation.constraints.Min;
import java.util.Map;

public class CreateProduct {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        //      @NotNull
        @Min(1)
        private Long id;

        private String name;

        private Long price;

        private String explanation;

        private String seller;


    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private Long id;

        private String name;

        private Long price;

        private String explanation;

        private Boolean isSoldout;

        private String seller;

        private Long salesVolume;

        public static Response from(ProductDto productDto){
            return Response.builder()
                    .id(productDto.getId())
                    .name(productDto.getName())
                    .price(productDto.getPrice())
                    .explanation(productDto.getExplanation())
                    .isSoldout(productDto.getIsSoldout())
                    .seller(productDto.getSeller())
                    .salesVolume(productDto.getSalesVolume())
                    .build();
        }
    }

}
