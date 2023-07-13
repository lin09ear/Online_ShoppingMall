package com.zerobase.shoppingmall.controller;

import com.zerobase.shoppingmall.domain.Member;
import com.zerobase.shoppingmall.dto.MemberFormDto;
import com.zerobase.shoppingmall.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping(value = "/")
    public String main(){
        return "main";
    }
}
