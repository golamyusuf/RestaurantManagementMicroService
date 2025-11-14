package com.golam.orderservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTOFromFE {
    private List<FoodItemDto> foodItemDtoList;
    private RestaurantDTO restaurant;
    private Integer userId;
}
