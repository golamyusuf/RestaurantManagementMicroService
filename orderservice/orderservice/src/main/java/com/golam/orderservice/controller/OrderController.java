package com.golam.orderservice.controller;

import com.golam.orderservice.dtos.OrderDTO;
import com.golam.orderservice.dtos.OrderDTOFromFE;
import com.golam.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTOFromFE orderDetails) {
          OrderDTO orderDTO = orderService.createOrder(orderDetails);
          return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }
}
