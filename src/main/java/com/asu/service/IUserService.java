package com.asu.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.asu.model.RequestUser;
import com.asu.model.User;

public interface IUserService {

    public User createUser(RequestUser user, Pageable page);

    public User readUser(int id);

    public List<User> readUsers();

    public User updateUser(int id, RequestUser user);

    public String deleteUser(int id);
}
