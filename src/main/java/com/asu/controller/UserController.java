package com.asu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asu.model.RequestUser;
import com.asu.model.UserModel;
import com.asu.service.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService ser;

    @GetMapping("/read/{Id}")
    public UserModel readUser(@PathVariable("Id") int identity) {
        return ser.readUser(identity);
    }

    @GetMapping("/readall")
    public List<UserModel> readUsers() {
        return ser.readUsers();
    }

    @PostMapping("/update/{Id}")
    public UserModel updateUser(@PathVariable("Id") int identity, @RequestBody RequestUser user) {
        return ser.updateUser(identity, user);
    }

    @PostMapping("/remove/{Id}")
    public String updateUser(@PathVariable("Id") int identity) {
        return ser.deleteUser(identity);
    }

}
