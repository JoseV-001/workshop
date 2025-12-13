package com.josev001.WorkShop.repositories;

import com.josev001.WorkShop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
