package com.demoDigital.demo.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.demoDigital.demo.customModel.OrderHistory;
import com.demoDigital.demo.model.Food;
import com.demoDigital.demo.model.FoodOrder;
import com.demoDigital.demo.repository.FoodOrderRepository;
import com.demoDigital.demo.repository.FoodRepository;
import com.demoDigital.demo.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodOrderService {
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    UserRepository userRepo;

    @Autowired
    FoodRepository foodRepo;

    @Autowired
    FoodOrderRepository foodOrderRepo;

    // GET
    public List<OrderHistory> getHistory(String email) {
        List<FoodOrder> orderList = foodOrderRepo.findAllbyEmail(email);
        List<OrderHistory> OrderHistory = new ArrayList<>();

        for (FoodOrder order : orderList) {
            Food food = foodRepo.getById(order.getFood_id());
            OrderHistory item = new OrderHistory();
            item.updateModel(item, order, food);
            OrderHistory.add(item);
        }
        return OrderHistory;
    }

    public List<FoodOrder> createOrder(List<FoodOrder> receiveOrder) {
        List<FoodOrder> listFood = new ArrayList<>();
        try {
            LocalDateTime current = LocalDateTime.now();
            for (FoodOrder foodOrder : receiveOrder) {
                Long food_id = foodOrder.getFood_id();
                if (food_id == null) {
                    System.out.println("Invalid value food id!");
                    return null;
                }
                foodOrder.setCreatedAt(current);
                foodOrderRepo.save(foodOrder);
                listFood.add(foodOrder);
            }
            // Iterable<Food> resultId = foodRepo.findAllById(listId);
            return listFood;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

}
