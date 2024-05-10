package com.asu.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.asu.model.RequestUser;
import com.asu.model.User;
import com.asu.repository.IUserRepo;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepo repo ;

    @Override
    public User createUser(@RequestBody RequestUser reuser, Pageable page) {
        User user=new User();
        BeanUtils.copyProperties(reuser, user);
    
        return repo.save(user);
    }

}
