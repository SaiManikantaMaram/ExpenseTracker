package com.asu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asu.model.RequestUser;
import com.asu.model.User;
import com.asu.service.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService ser;

    @PostMapping("/create")
    public User createUser(@Valid @RequestBody RequestUser user,Pageable page)
    {
      
        return ser.createUser(user,page);
    }    
}
