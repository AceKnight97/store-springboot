package com.demoDigital.demo.services;

import java.util.List;

import com.demoDigital.demo.customModel.CreateUserRequest;
import com.demoDigital.demo.model.User;
import com.demoDigital.demo.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    UserRepository userRepo;

    // GET
    public User getUser(Long id) {
        return userRepo.findById(id).get();
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    // POST
    public User createUser(CreateUserRequest user) {
        String email = user.getEmail();
        User newUser = userRepo.findByEmail(email);
        if (newUser != null) {
            System.out.println("newUser already exist!");
            return null;
        }
        // System.out.println("newUser: " + user.getEmail() + " " + user.getUsername() +
        // " " + user.getPassword());
        User existUser = new User();
        existUser.setUsername(user.getUsername());
        existUser.setEmail(email);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        existUser.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(existUser);
    }

}
