package com.javaCodeSpringData.SpringDataProjecMapper.service;

import com.javaCodeSpringData.SpringDataProjecMapper.controller.exception.CustomNotFoundException;
import com.javaCodeSpringData.SpringDataProjecMapper.model.Order;
import com.javaCodeSpringData.SpringDataProjecMapper.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
            .orElseThrow(() -> new CustomNotFoundException("Ордер не найден"));
    }

    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public Order updateOrder(Long orderId, Order order) {
        Order existingOrder = getOrderById(orderId);
        order.setOrderId(existingOrder.getOrderId());
        return orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}