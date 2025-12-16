package com.josev001.WorkShop.repositories;

import com.josev001.WorkShop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
