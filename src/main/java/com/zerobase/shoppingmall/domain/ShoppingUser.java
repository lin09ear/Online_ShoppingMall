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
    private Long user_id;

    private String password;

    private String user_name;

    private String birth_date;

    @CreatedDate
    private LocalDateTime created_date;

    private String gender;

    private String email;

    private String address;
}
