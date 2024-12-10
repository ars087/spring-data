package com.javaCodeSpringMVC.SpringMvcProjectMapper.repository;

import com.javaCodeSpringMVC.SpringMvcProjectMapper.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}