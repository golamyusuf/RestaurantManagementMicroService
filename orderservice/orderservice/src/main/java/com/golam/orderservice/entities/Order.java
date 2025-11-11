package com.golam.orderservice.entities;


import com.golam.orderservice.dtos.FoodItemDto;
import com.golam.orderservice.dtos.RestaurantDTO;
import com.golam.orderservice.dtos.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("orders")
public class Order {
    private Integer orderId;
    private List<FoodItemDto> foodItemDtoList;
    private RestaurantDTO restaurant;
    private UserDTO userDTO;
}
