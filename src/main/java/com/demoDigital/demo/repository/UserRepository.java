package com.demoDigital.demo.repository;

import com.demoDigital.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Query(value = "SELECT * FROM personal_info info where info.email LIKE :email", nativeQuery = true)
  User findByEmail(String email);

}
