package com.zerobase.shoppingmall.dto;

import com.zerobase.shoppingmall.domain.CartItem;
import lombok.*;

import javax.validation.constraints.Min;
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

        private Long cartId;

        private Map<Long, CartItem> cartItems;

        public static Response from(CartDto cartDto) {
            return Response.builder()
                    .cartId(cartDto.getCartId())
                    .cartItems(cartDto.getCartItems())
                    .build();
        }
    }

}
