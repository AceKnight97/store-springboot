package com.demoDigital.demo.repository;

import java.util.List;

import com.demoDigital.demo.model.Food;
import com.demoDigital.demo.model.FoodOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {

  @Query(value = "SELECT * FROM food_order f where f.email LIKE :email", nativeQuery = true)
  List<FoodOrder> findAllbyEmail(String email);

  // @Query(value = "SELECT * FROM food f where f.name LIKE :name", nativeQuery =
  // true)
  // Food findByName(String name);
}
