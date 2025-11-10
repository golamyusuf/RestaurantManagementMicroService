package com.golam.foodCatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDto {
    private int id;
    private String name;
    private String description;
    private Number price;
    private boolean isVeg;
    private Integer restaurantId;
}
