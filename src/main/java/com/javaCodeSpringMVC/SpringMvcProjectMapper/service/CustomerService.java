package com.javaCodeSpringMVC.SpringMvcProjectMapper.service;

import com.javaCodeSpringMVC.SpringMvcProjectMapper.model.Customer;
import com.javaCodeSpringMVC.SpringMvcProjectMapper.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {


    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
            .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long customerId, Customer customer) {
        Customer existingCustomer = getCustomerById(customerId);
        customer.setCustomerId(existingCustomer.getCustomerId());
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}