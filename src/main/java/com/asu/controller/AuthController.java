package com.asu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asu.model.RequestUser;
import com.asu.model.User;
import com.asu.service.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IUserService ser;

    @GetMapping("/login")
    public String loginPage() {
        return " User is Logged in";
    }

    @PostMapping("/register")
    public User createUser(@Valid @RequestBody RequestUser user, Pageable page) {
        return ser.createUser(user, page);
    }

    @GetMapping("hello")
    public String helloPage() {
        return "Hello World";
    }

}
