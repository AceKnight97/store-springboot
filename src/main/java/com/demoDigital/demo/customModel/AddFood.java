package com.demoDigital.demo.customModel;

import java.util.ArrayList;
import java.util.List;

import com.demoDigital.demo.model.Food;

import org.hibernate.mapping.Any;

import lombok.Data;

@Data
public class AddFood {

    private String email;
    private List<Food> food = new ArrayList<>();

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Food> getFood() {
        return this.food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }

}
