package com.asu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asu.model.UserModel;

public interface IUserRepo extends JpaRepository<UserModel, Integer> {
    public Boolean existsByEmail(String email);

    public Optional<UserModel> findByEmail(String email);
}
