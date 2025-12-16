package com.josev001.WorkShop.repositories;

import com.josev001.WorkShop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
