package com.golam.foodCatalogue.services;

import com.golam.foodCatalogue.dto.FoodItemDto;
import com.golam.foodCatalogue.entities.FoodItem;
import com.golam.foodCatalogue.mappers.FoodItemMapper;
import com.golam.foodCatalogue.repositories.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodCatalogService {
    @Autowired
    FoodItemRepository foodItemRepository;

    public FoodItemDto addFoodItem(FoodItemDto foodItemDto) {
        FoodItem savedFoodItem = foodItemRepository.save(FoodItemMapper.Instance.foodItemDtoToFoodItem(foodItemDto));
        return FoodItemMapper.Instance.foodItemToFoodItemDto(savedFoodItem);
    }
}
