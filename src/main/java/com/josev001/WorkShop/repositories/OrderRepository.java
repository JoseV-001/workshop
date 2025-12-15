package com.josev001.WorkShop.repositories;

import com.josev001.WorkShop.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
}
