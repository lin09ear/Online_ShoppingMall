package com.zerobase.shoppingmall.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ShoppingUser {

    @Id
    @GeneratedValue
    private Long id;

    private String password;

    private String name;

    private String birthday;

    @CreatedDate
    private LocalDateTime createdDate;

    private String gender;

    private String email;

    private String address;

}
