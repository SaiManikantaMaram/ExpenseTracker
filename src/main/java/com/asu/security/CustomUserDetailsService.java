package com.asu.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.asu.Exceptions.UserNotFoundException;
import com.asu.model.UserModel;
import com.asu.repository.IUserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        System.out.println("Hello CustomUserDetailsService is called");
        UserModel user = repo.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User Not Found for the Email"));
        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
