package com.demoDigital.demo.customModel;

import java.util.ArrayList;
import java.util.List;

import com.demoDigital.demo.model.FoodOrder;

import lombok.Data;

@Data
public class CreateAnyCustomerOrder {
    private List<FoodOrder> food = new ArrayList<>();
    private CreateUserRequest customer;

    public List<FoodOrder> getFood() {
        return this.food;
    }

    public void setFood(List<FoodOrder> food) {
        this.food = food;
    }

    public CreateUserRequest getCustomer() {
        return this.customer;
    }

    public void setCustomer(CreateUserRequest customer) {
        this.customer = customer;
    }

}
