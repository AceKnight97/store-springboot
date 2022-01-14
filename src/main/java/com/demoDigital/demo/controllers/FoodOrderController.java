package com.demoDigital.demo.controllers;

import java.util.List;

import com.demoDigital.demo.customModel.CreateAnyCustomerOrder;
import com.demoDigital.demo.customModel.CreateUserRequest;
import com.demoDigital.demo.customModel.OrderHistory;
import com.demoDigital.demo.model.FoodOrder;
import com.demoDigital.demo.model.MutationResponse;
import com.demoDigital.demo.model.User;
import com.demoDigital.demo.services.AuthService;
import com.demoDigital.demo.services.FoodOrderService;
import com.demoDigital.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/foodorder")
public class FoodOrderController {
    @Autowired
    AuthService authService;

    @Autowired
    FoodOrderService foodOrderService;

    @Autowired
    UserService userService;

    // GET
    @GetMapping("/history")
    public List<OrderHistory> getHistory(@RequestHeader("Authorization") String token) {
        User user = authService.authUser(token);
        if (user == null || user.getEmail() == null) {
            return null;
        }
        return foodOrderService.getHistory(user.getEmail());
    }

    // POST
    @PostMapping("/createorder")
    public MutationResponse createOrder(@RequestBody List<FoodOrder> receiveOrder) {
        System.out.println("createorder");
        MutationResponse res = new MutationResponse();
        List<FoodOrder> saveFood = foodOrderService.createOrder(receiveOrder);
        res.isSuccess = !(saveFood == null);
        res.data = saveFood;
        return res;
    }

    @PostMapping("/createanycustomerorder")
    public MutationResponse createAnyCustomerOrder(@RequestBody CreateAnyCustomerOrder data) {
        // @RequestBody List<FoodOrder> receiveOrder,
        // @RequestBody CreateUserRequest anyCustomer
        System.out.println("createAnyCustomerOrder");
        List<FoodOrder> receiveOrder = data.getFood();
        CreateUserRequest anyCustomer = data.getCustomer();
        MutationResponse res = new MutationResponse();

        User user = userService.createUser(anyCustomer);
        if (user == null) {
            System.out.println("Already created account!");
        }
        List<FoodOrder> saveFood = foodOrderService.createAnyCustomerOrder(receiveOrder);
        res.isSuccess = !(saveFood == null);
        res.data = saveFood;
        return res;
    }
}
