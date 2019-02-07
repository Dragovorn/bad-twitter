package com.dragovorn.bt.controller;

import com.dragovorn.bt.entity.user.CreatedUser;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AccountController {

    private static Map<Integer, CreatedUser> users = new HashMap<>();

    @GetMapping("/create_account")
    public String createAccountGET(@CookieValue(value = "sessionId", required = false) String sessionId) {
        if (sessionId != null) {
            return "redirect:/";
        }

        return "create-account";
    }

    @PostMapping(value = "/create_account", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createAccountPOST(RedirectAttributes redirectAttributes, @RequestParam("email") String email, @RequestParam("username") String username, @RequestParam("password") String password) {
        CreatedUser user = new CreatedUser(email, username, password);

        System.out.println(user);

        redirectAttributes.addAttribute("created", true);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginGET() {
        return "login";
    }

    @PostMapping("/login")
    public void loginPOST() {

    }
}
