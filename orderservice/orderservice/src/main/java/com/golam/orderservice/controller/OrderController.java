package com.golam.orderservice.controller;

import com.golam.orderservice.dtos.OrderDTO;
import com.golam.orderservice.services.OrderService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public OrderDTO createOrder(OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }
}
