package com.josev001.WorkShop.services;

import com.josev001.WorkShop.entities.Product;
import com.josev001.WorkShop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product finById(Long id){
       Optional<Product> obj = repository.findById(id);
       return obj.get();
    }

}
