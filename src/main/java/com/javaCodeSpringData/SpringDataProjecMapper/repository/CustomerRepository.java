package com.javaCodeSpringData.SpringDataProjecMapper.repository;

import com.javaCodeSpringData.SpringDataProjecMapper.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}