package com.javaCodeSpringData.SpringDataProjecMapper.repository;

import com.javaCodeSpringData.SpringDataProjecMapper.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}