package com.demoDigital.demo.customModel;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class HistoryFilter {

    private String email;
    private Long food_id;
    private Number quantity;
    private LocalDateTime createdAt = LocalDateTime.now();
    private String title;
    private String name;
    private Number rating;
    private Number price;
    private QuantityType quantityType = QuantityType.WEIGHT;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

}
