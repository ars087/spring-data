package com.javaCodeSpringMVC.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaCodeSpringMVC.controller.exception.CustomBedRequestException;
import com.javaCodeSpringMVC.model.Order;
import com.javaCodeSpringMVC.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public String getOrderById(@PathVariable Long orderId) {
        try {
            Order order = orderService.getOrderById(orderId);
            String response;
            try {
                response = objectMapper.writeValueAsString(order);
            } catch (JsonProcessingException e) {
                throw new CustomBedRequestException(e.getMessage());
            }
            return ResponseEntity.ok(response).toString();
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND).toString();
        }
    }

    @PostMapping

    public String createOrder(@Valid @RequestBody String orderRequest) {
        Order order;
        try {
            order = objectMapper.readValue(orderRequest, Order.class);
        } catch (JsonProcessingException e) {
            return ResponseEntity.badRequest().body("Не верные данные ввода").toString();
        }
        orderService.createOrder(order);
        return ResponseEntity.ok().body("Заказ создан").toString();
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long orderId, @Valid @RequestBody Order order) {
        try {
            Order updatedOrder = orderService.updateOrder(orderId, order);
            return ResponseEntity.ok(updatedOrder);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }
}