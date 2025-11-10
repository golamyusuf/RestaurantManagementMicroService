package com.golam.foodCatalogue.controllers;

import com.golam.foodCatalogue.dto.FoodItemDto;
import com.golam.foodCatalogue.services.FoodCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatelogueController {
    @Autowired
    FoodCatalogService foodCatalogService;

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDto> addFoodItem(@RequestBody FoodItemDto  foodItemDto){
        FoodItemDto savedFoodItemDto = foodCatalogService.addFoodItem(foodItemDto);
        return new ResponseEntity<>(savedFoodItemDto, HttpStatus.CREATED);

    }

}
