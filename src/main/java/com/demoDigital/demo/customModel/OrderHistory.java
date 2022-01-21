package com.demoDigital.demo.customModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.demoDigital.demo.model.Food;
import com.demoDigital.demo.model.FoodOrder;
import com.demoDigital.demo.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class OrderHistory {

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Food food = new Food();
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private FoodOrder foodOrder = new FoodOrder();
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private User user = new User();

    public OrderHistory(Food food, FoodOrder foodOrder, User user) {
        this.food = food;
        this.foodOrder = foodOrder;
        this.user = user;
    }

    public Food getFood() {
        return this.food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public FoodOrder getFoodOrder() {
        return this.foodOrder;
    }

    public void setFoodOrder(FoodOrder foodOrder) {
        this.foodOrder = foodOrder;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
