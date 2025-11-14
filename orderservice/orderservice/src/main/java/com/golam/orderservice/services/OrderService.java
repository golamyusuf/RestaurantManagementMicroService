package com.golam.orderservice.services;

import com.golam.orderservice.dtos.OrderDTO;
import com.golam.orderservice.dtos.OrderDTOFromFE;
import com.golam.orderservice.dtos.UserDTO;
import com.golam.orderservice.entities.Order;
import com.golam.orderservice.entities.Sequence;
import com.golam.orderservice.mappers.OrderMapper;
import com.golam.orderservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

    public OrderDTO createOrder(OrderDTOFromFE orderDetails) {
        Integer nextOrderId = sequenceGenerator.getNextSequenceOrderId();
        UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
        Order orderToSave = new Order(nextOrderId,
                orderDetails.getFoodItemDtoList(),
                orderDetails.getRestaurant(),
                userDTO);
        Order orderToBeSaved = orderRepository.save(orderToSave);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
    }
    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
        return restTemplate.getForObject("http://USER-INFO-SERVICE/userInfo/getuserById/" + userId, UserDTO.class);
    }
}
