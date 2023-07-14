package com.zerobase.shoppingmall.dto;

import lombok.*;

import javax.validation.constraints.Min;

public class CreateProduct {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        //      @NotNull
        @Min(1)
        private Long productId;

        private String name;

        private Long price;

        private String explanation;

        private String seller;

        private Integer stock;


    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private Long productId;

        private String name;

        private Long price;

        private String explanation;

        private Boolean isSoldout;

        private String seller;

        private Long salesVolume;

        private Integer stock;

        public static Response from(ProductDto productDto){
            return Response.builder()
                    .productId(productDto.getProductId())
                    .name(productDto.getName())
                    .price(productDto.getPrice())
                    .explanation(productDto.getExplanation())
                    .isSoldout(productDto.getIsSoldout())
                    .seller(productDto.getSeller())
                    .salesVolume(productDto.getSalesVolume())
                    .stock(productDto.getStock())
                    .build();
        }
    }

}
