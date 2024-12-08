package com.javaCodeSpringData.SpringDataProject.repository;

import com.javaCodeSpringData.SpringDataProject.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
