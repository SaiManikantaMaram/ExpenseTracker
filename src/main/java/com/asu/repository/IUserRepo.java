package com.asu.repository;

import com.asu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer>{
    public Boolean existsByEmail(String email);
}
