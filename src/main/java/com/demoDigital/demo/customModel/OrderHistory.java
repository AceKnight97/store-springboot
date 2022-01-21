package com.demoDigital.demo.customModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.demoDigital.demo.model.Food;
import com.demoDigital.demo.model.FoodOrder;
import com.demoDigital.demo.model.User;

import lombok.Data;

@Data
public class OrderHistory {

    private Long food_id;
    private Number quantity;
    private LocalDateTime createdAt;
    private String email;
    private String title;
    private String name;
    private Number rating;
    private Number price;
    private String username;
    private String phone;
    private String address;
    private Gender gender;
    private LocalDate dob;
    private Roles role;
    private String notes;
    private QuantityType quantityType = QuantityType.WEIGHT;

    public Long getFood_id() {
        return this.food_id;
    }

    public void setFood_id(Long food_id) {
        this.food_id = food_id;
    }

    public Number getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getRating() {
        return this.rating;
    }

    public void setRating(Number rating) {
        this.rating = rating;
    }

    public Number getPrice() {
        return this.price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public QuantityType getQuantityType() {
        return this.quantityType;
    }

    public void setQuantityType(QuantityType quantityType) {
        this.quantityType = quantityType;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Roles getRole() {
        return this.role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void updateModel(OrderHistory current, FoodOrder foodOrder, Food food) {
        current.setFood_id(foodOrder.getFood_id());
        current.setQuantity(foodOrder.getQuantity());
        current.setCreatedAt(foodOrder.getCreatedAt());
        current.setEmail(foodOrder.getEmail());

        current.setName(food.getName());
        current.setTitle(food.getTitle());
        current.setRating(food.getRating());
        current.setPrice(food.getPrice());
        current.setQuantityType(food.getQuantityType());
    }

    public void updateModelUser(OrderHistory current, FoodOrder foodOrder, Food food, User user) {
        current.setFood_id(foodOrder.getFood_id());
        current.setQuantity(foodOrder.getQuantity());
        current.setCreatedAt(foodOrder.getCreatedAt());
        current.setEmail(foodOrder.getEmail());

        current.setName(food.getName());
        current.setTitle(food.getTitle());
        current.setRating(food.getRating());
        current.setPrice(food.getPrice());
        current.setQuantityType(food.getQuantityType());

        current.setPhone(user.getPhone());
        current.setAddress(user.getAddress());
        current.setGender(user.getGender());
        current.setDob(user.getDob());
        current.setUsername(user.getUsername());
    }

}
