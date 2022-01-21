package com.demoDigital.demo.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.demoDigital.demo.customModel.HistoryFilter;
import com.demoDigital.demo.customModel.OrderHistory;
import com.demoDigital.demo.customModel.UpdateOrderStatus;
import com.demoDigital.demo.model.Food;
import com.demoDigital.demo.model.FoodOrder;
import com.demoDigital.demo.model.User;
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
    public List<OrderHistory> getHistory(User user, LocalDate createdAt) {
        List<FoodOrder> orderList = new ArrayList<>();
        if (createdAt == null) {
            System.out.println("createdAt == null");
            orderList = foodOrderRepo.findAllbyEmail(user.getEmail());
        } else {
            System.out.println("createdAt != null");
            orderList = foodOrderRepo.findAllbyEmailAndDate(user.getEmail(), createdAt);
        }
        List<OrderHistory> orderHis = new ArrayList<>();

        for (FoodOrder order : orderList) {
            Food food = foodRepo.getById(order.getFood_id());
            OrderHistory item = new OrderHistory(food, order, user);
            orderHis.add(item);
        }
        return orderHis;
    }

    public List<OrderHistory> getAllHistory(HistoryFilter filterObj) {
        List<User> users = userRepo.findAll();
        LocalDateTime localDateTime = filterObj.getCreatedAt();
        LocalDate createdAt = LocalDate.now();
        if (localDateTime != null) {
            createdAt = localDateTime.toLocalDate();
        }
        System.out.println("createdAt: " + createdAt);
        List<OrderHistory> res = new ArrayList<>();
        for (User user : users) {
            List<OrderHistory> orderHis = this.getHistory(user, createdAt);
            res.addAll(orderHis);
        }
        return res;
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

    public List<FoodOrder> createAnyCustomerOrder(List<FoodOrder> receiveOrder) {
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

    public FoodOrder changeOrderStatus(UpdateOrderStatus data) {
        try {
            FoodOrder foodOrder = foodOrderRepo.findById(data.getFood_id()).get();
            foodOrder.setStatus(data.getStatus());
            foodOrderRepo.save(foodOrder);
            return foodOrder;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }
}
