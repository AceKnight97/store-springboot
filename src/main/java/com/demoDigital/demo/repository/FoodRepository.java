package com.demoDigital.demo.repository;

import com.demoDigital.demo.model.Food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

  // @Query(value = "SELECT * FROM user u where u.email LIKE
  // :email", nativeQuery = true)
  // Food findByEmail(String email);

  @Query(value = "SELECT * FROM food f where f.name LIKE :name", nativeQuery = true)
  Food findByName(String name);
}
