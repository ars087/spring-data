package com.javaCodeSpringData.SpringDataProjecMapper.repository;

import com.javaCodeSpringData.SpringDataProjecMapper.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}