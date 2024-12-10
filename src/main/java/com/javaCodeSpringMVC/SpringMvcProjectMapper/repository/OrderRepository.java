package com.javaCodeSpringMVC.SpringMvcProjectMapper.repository;

import com.javaCodeSpringMVC.SpringMvcProjectMapper.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}