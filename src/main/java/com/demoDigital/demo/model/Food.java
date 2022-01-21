package com.demoDigital.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.demoDigital.demo.customModel.QuantityType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "food")
@Getter
@Setter
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String name;
    private Number rating;
    private Number price;
    private QuantityType quantityType = QuantityType.WEIGHT;
    private LocalDateTime createdAt;
    @Lob
    private String image;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Food updateModel(Food oldFood, Food newFood) {
        oldFood.setImage(newFood.getImage());
        oldFood.setTitle(newFood.getTitle());
        oldFood.setName(newFood.getName());
        oldFood.setPrice(newFood.getPrice());
        oldFood.setQuantityType(newFood.getQuantityType());
        oldFood.setRating(newFood.getRating());
        return oldFood;
    }

}
