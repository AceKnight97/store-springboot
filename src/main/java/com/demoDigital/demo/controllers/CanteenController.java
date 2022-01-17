package com.demoDigital.demo.controllers;

import java.util.List;

import com.demoDigital.demo.customModel.AddFood;
import com.demoDigital.demo.customModel.Roles;
import com.demoDigital.demo.model.Food;
import com.demoDigital.demo.model.MutationResponse;
import com.demoDigital.demo.model.User;
import com.demoDigital.demo.repository.UserRepository;
import com.demoDigital.demo.services.AuthService;
import com.demoDigital.demo.services.FoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/canteen")
public class CanteenController {
    @Autowired
    AuthService authService;

    @Autowired
    FoodService foodService;

    @Autowired
    UserRepository userRepo;

    // GET
    @GetMapping("/menu")
    public List<Food> getMenu() {
        return foodService.getMenu();
    }

    // POST
    @PostMapping("/addfood")
    public MutationResponse addFood(@RequestBody AddFood receiveFood) {
        // String email = receiveFood.getEmail();
        List<Food> food = receiveFood.getFood();
        String email = receiveFood.getEmail();
        User user = userRepo.findByEmail(email);
        MutationResponse res = new MutationResponse();
        if (user == null || user.getRole() != Roles.Admin) {
            res.isSuccess = false;
            res.message = "Invalid user!";
            return res;
        }
        // System.out.println("email: " + email);
        // System.out.println("food: " + food);
        List<Food> saveFood = foodService.addFood(food);
        res.isSuccess = !(saveFood == null);
        res.data = saveFood;
        return res;
    }

    // PUT
    @PutMapping("/updatefood")
    public MutationResponse updateFood(@RequestBody AddFood receiveFood) {
        // String email = receiveFood.getEmail();
        List<Food> food = receiveFood.getFood();
        // System.out.println("email: " + email);
        // System.out.println("food: " + food);
        MutationResponse res = new MutationResponse();
        List<Food> saveFood = foodService.updateFood(food);
        res.isSuccess = !(saveFood == null);
        res.data = saveFood;
        return res;
    }

    // PUT
    @DeleteMapping("/deletefood")
    public MutationResponse deleteFood(@RequestBody AddFood receiveFood) {
        // String email = receiveFood.getEmail();
        List<Food> food = receiveFood.getFood();
        // System.out.println("email: " + email);
        // System.out.println("food: " + food);
        MutationResponse res = new MutationResponse();
        List<Food> saveFood = foodService.deleteFood(food);
        res.isSuccess = !(saveFood == null);
        res.data = saveFood;
        return res;
    }
}
