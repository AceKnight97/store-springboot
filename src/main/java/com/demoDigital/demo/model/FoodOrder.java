package com.demoDigital.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "food_order")
@Getter
@Setter
@NoArgsConstructor
public class FoodOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Number quantity;
    private Long food_id;
    private LocalDateTime createdAt;
    private String email;
    private String notes;
    private String status;
    private Number price;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Number getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

    public Long getFood_id() {
        return this.food_id;
    }

    public void setFood_id(Long food_id) {
        this.food_id = food_id;
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

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Number getPrice() {
        return this.price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public void updateModel(FoodOrder oldOrder, FoodOrder newOrder) {
        oldOrder.setCreatedAt(LocalDateTime.now());
        oldOrder.setEmail(newOrder.getEmail());
        oldOrder.setFood_id(newOrder.getFood_id());
        oldOrder.setQuantity(newOrder.getQuantity());
        oldOrder.setNotes(newOrder.getNotes());
        oldOrder.setStatus(newOrder.getStatus());
        oldOrder.setPrice(newOrder.getPrice());
    }

}
