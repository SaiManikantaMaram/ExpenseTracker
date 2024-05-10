package com.asu.service;

import org.springframework.data.domain.Pageable;

import com.asu.model.RequestUser;
import com.asu.model.User;

public interface IUserService {
    public User createUser(RequestUser user, Pageable page);
}
