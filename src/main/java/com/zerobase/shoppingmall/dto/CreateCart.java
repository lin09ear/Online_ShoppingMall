package com.zerobase.shoppingmall.dto;

import com.zerobase.shoppingmall.domain.CartItem;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Map;

public class CreateCart {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
  //      @NotNull
        @Min(1)
        private Long id;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private Long id;

        private Map<Long, CartItem> cartItems;

        public static Response from(CartDto cartDto) {
            return Response.builder()
                    .id(cartDto.getId())
                    .cartItems(cartDto.getCartItems())
                    .build();
        }
    }

}
