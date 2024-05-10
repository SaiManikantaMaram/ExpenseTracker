package com.asu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.asu.Exceptions.ItemExistsException;
import com.asu.Exceptions.UserNotFoundException;
import com.asu.model.RequestUser;
import com.asu.model.User;
import com.asu.repository.IUserRepo;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepo repo;

    @Override
    public User createUser(@RequestBody RequestUser reuser, Pageable page) {

        if (repo.existsByEmail(reuser.getEmail())) {
            throw new ItemExistsException(" Account already exists for the Email: " + reuser.getEmail());
        }
        User user = new User();
        BeanUtils.copyProperties(reuser, user);
        return repo.save(user);
    }

    @Override
    public User readUser(int id) {

        Optional<User> os = repo.findById(id);
        if (os.isPresent()) {
            return os.get();
        } else
            throw new UserNotFoundException("User Not Found with ID: " + id);
    }

    @Override
    public List<User> readUsers() {
        return repo.findAll();
    }

    @Override
    public User updateUser(int id, RequestUser reuser) {
        User user = readUser(id);
        user.setName(reuser.getName() != null ? reuser.getName() : user.getName());
        user.setPassword(reuser.getPassword() != null ? reuser.getPassword() : user.getPassword());
        user.setEmail(reuser.getEmail() != null ? reuser.getEmail() : user.getEmail());
        user.setAge(reuser.getAge() != 0 ? reuser.getAge() : user.getAge());
    
        return repo.save(user);
    }

    @Override
    public String deleteUser(int id) {
        User user = readUser(id);
        repo.deleteById(id);
        return "Successfully deleted the User " + user.getName() + " with Id: " + user.getId();
    }

}
