package com.asu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.asu.Exceptions.ItemExistsException;
import com.asu.Exceptions.UserNotFoundException;
import com.asu.model.RequestUser;
import com.asu.model.UserModel;
import com.asu.repository.IUserRepo;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepo repo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserModel createUser(@RequestBody RequestUser requestUser, Pageable page) {

        if (repo.existsByEmail(requestUser.getEmail())) {
            throw new ItemExistsException(" Account already exists for the Email: " + requestUser.getEmail());
        }
        UserModel user = new UserModel();

        user.setName(requestUser.getName());
        user.setEmail(requestUser.getEmail());
        // Encode the password using bcrypt before saving
        user.setPassword(passwordEncoder.encode(requestUser.getPassword()));
        return repo.save(user);
    }

    @Override
    public UserModel readUser(int id) {

        Optional<UserModel> os = repo.findById(id);
        if (os.isPresent()) {
            return os.get();
        } else
            throw new UserNotFoundException("User Not Found with ID: " + id);
    }

    @Override
    public List<UserModel> readUsers() {
        return repo.findAll();
    }

    @Override
    public UserModel updateUser(int id, RequestUser reuser) {
        UserModel user = readUser(id);
        user.setName(reuser.getName() != null ? reuser.getName() : user.getName());
        user.setPassword(reuser.getPassword() != null ? reuser.getPassword() : user.getPassword());
        user.setEmail(reuser.getEmail() != null ? reuser.getEmail() : user.getEmail());
        user.setAge(reuser.getAge() != 0 ? reuser.getAge() : user.getAge());

        return repo.save(user);
    }

    @Override
    public String deleteUser(int id) {
        UserModel user = readUser(id);
        repo.deleteById(id);
        return "Successfully deleted the User " + user.getName() + " with Id: " + user.getId();
    }

    @Override
    public UserModel getLoggedInUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String Email = authentication.getName();
        return repo.findByEmail(Email).orElseThrow(() -> new UserNotFoundException("User Not Found with ID: " + Email));

    }

}
