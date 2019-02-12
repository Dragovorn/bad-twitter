package com.dragovorn.bt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(@CookieValue(value = "sessionId", required = false) String sessionId, Model model, HttpServletResponse response) {
        if (sessionId != null) {
            model.addAttribute("sessionId", sessionId);

            return "home";
        } else {
            return "no-auth-index";
        }
    }
}
