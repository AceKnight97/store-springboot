package com.demoDigital.demo.customModel;

import lombok.Data;

@Data
public class UpdateOrderStatus {
    private Long food_id;
    private String status;

    public Long getFood_id() {
        return this.food_id;
    }

    public void setFood_id(Long food_id) {
        this.food_id = food_id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
