package com.demoDigital.demo.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.demoDigital.demo.model.Food;
import com.demoDigital.demo.model.FoodOrder;
import com.demoDigital.demo.repository.FoodOrderRepository;
import com.demoDigital.demo.repository.FoodRepository;
import com.demoDigital.demo.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    UserRepository userRepo;

    @Autowired
    FoodRepository foodRepo;

    @Autowired
    FoodOrderRepository foodOrderRepo;

    // GET
    public List<Food> getMenu() {
        return foodRepo.findAll();
    }

    public List<Food> userHistory() {
        return foodRepo.findAll();
    }

    // POST
    public List<Food> addFood(List<Food> receiveFood) {
        List<Food> listFood = new ArrayList<>();
        try {
            for (Food food : receiveFood) {
                if (food.getId() != null) {
                    System.out.println("Invalid value food id!");
                    // Food checkExistedId = foodRepo.findById(food.getId()).get();
                    return null;
                }
                foodRepo.save(food);
                listFood.add(food);
            }
            // Iterable<Food> resultId = foodRepo.findAllById(listId);
            return listFood;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    // PUT
    public List<Food> updateFood(List<Food> receiveFood) {
        List<Food> listFood = new ArrayList<>();
        try {
            for (Food food : receiveFood) {
                if (food.getId() == null) {
                    System.out.println("Invalid value food id!");
                    return null;
                }
                Food existedFood = foodRepo.findById(food.getId()).get();
                existedFood = existedFood.updateModel(existedFood, food);
                foodRepo.save(existedFood);
                listFood.add(existedFood);
            }
            return listFood;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    // DELETE
    public List<Food> deleteFood(List<Food> receiveFood) {
        List<Food> listFood = new ArrayList<>();
        try {
            for (Food food : receiveFood) {
                if (food.getId() == null) {
                    System.out.println("Invalid value food id!");
                    return null;
                }
                Food existedFood = foodRepo.findById(food.getId()).get();
                foodRepo.delete(existedFood);
                listFood.add(existedFood);
            }
            return listFood;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

}
