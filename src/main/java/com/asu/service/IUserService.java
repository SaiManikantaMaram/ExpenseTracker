package com.asu.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.asu.model.RequestUser;
import com.asu.model.UserModel;

public interface IUserService {

    public UserModel createUser(RequestUser user, Pageable page);

    public UserModel readUser(int id);

    public List<UserModel> readUsers();

    public UserModel updateUser(int id, RequestUser user);

    public String deleteUser(int id);

    public UserModel getLoggedInUser();
}
