package com.demoDigital.demo.controllers;

import java.util.List;

import com.demoDigital.demo.customModel.CreateUserRequest;
import com.demoDigital.demo.model.MutationResponse;
import com.demoDigital.demo.model.User;
import com.demoDigital.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    // GET
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping()
    public List<User> getUsers() {
        return userService.getUsers();
    }

    // POST
    @PostMapping("/createuser")
    public MutationResponse createUser(@RequestBody CreateUserRequest data) {
        MutationResponse response = new MutationResponse();
        // String username = data.getUsername();
        // String email = data.getEmail();
        // String password = data.getPassword();
        // System.out.println("username: " + username);
        // System.out.println("email: " + email);
        // System.out.println("password: " + password);
        User user = userService.createUser(data);
        if (user == null) {
            response.isSuccess = false;
            response.message = "User already existed!";
            return response;
        }
        response.data = user;
        return response;
    }

}
