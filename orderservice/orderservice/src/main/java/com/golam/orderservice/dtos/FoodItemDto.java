package com.golam.orderservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDto {
    private int id;
    private String name;
    private String description;
    private Number price;
    private boolean isVeg;
    private Integer restaurantId;
}
