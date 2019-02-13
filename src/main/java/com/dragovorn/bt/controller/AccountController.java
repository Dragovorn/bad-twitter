package com.dragovorn.bt.controller;

import com.dragovorn.bt.entity.user.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User createAccount(@RequestParam("email") String email,
                                    @RequestParam("username") String username,
                                    @RequestParam("password") String password,
                                    @RequestParam(value = "first_name", required = false) String firstName,
                                    @RequestParam(value = "last_name", required = false) String lastName,
                                    @RequestParam(value = "birth_date", required = false) @DateTimeFormat(pattern="MM/dd/yyyy") @Valid Date birthDate) {
        return User.builder().setEmail(email).setUsername(username).setPassword(password).setName(firstName, lastName).setBirthDate(birthDate).build();
    }
}
