package com.josev001.WorkShop.repositories;

import com.josev001.WorkShop.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}

