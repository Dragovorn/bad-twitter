package com.dragovorn.bt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @GetMapping("/create_account")
    public String createAccountGET() {
        return "create-account";
    }

    @PostMapping("create_account")
    public void createAccountPOST() {

    }

    @GetMapping("/login")
    public String loginGET() {
        return "login";
    }

    @PostMapping("/login")
    public void loginPOST() {

    }
}
