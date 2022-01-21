package com.demoDigital.demo.services;

import java.util.List;

import com.demoDigital.demo.customModel.CreateUserRequest;
import com.demoDigital.demo.customModel.Roles;
import com.demoDigital.demo.model.User;
import com.demoDigital.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final String adminKey = "0819541897";

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
        User existUser = new User();
        existUser.setUsername(user.getUsername());
        existUser.setEmail(email);
        existUser.setAddress(user.getAddress());
        existUser.setPhone(user.getPhone());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        existUser.setPassword(encoder.encode(user.getPassword()));
        if (encoder.matches(adminKey, existUser.getPassword())) {
            System.out.println("Admin's account");
            existUser.setRole(Roles.Admin);
        } else {
            System.out.println("Admin's account");
            existUser.setRole(Roles.Client);
        }

        return userRepo.save(existUser);
        // System.out.println("newUser: " + user.getEmail() + " " + user.getUsername() +
        // " " + user.getPassword());
    }

}
