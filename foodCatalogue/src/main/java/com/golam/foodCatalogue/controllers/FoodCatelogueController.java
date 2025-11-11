package com.golam.foodCatalogue.controllers;

import com.golam.foodCatalogue.dto.FoodCataloguePage;
import com.golam.foodCatalogue.dto.FoodItemDto;
import com.golam.foodCatalogue.entities.FoodItem;
import com.golam.foodCatalogue.mappers.FoodItemMapper;
import com.golam.foodCatalogue.services.FoodCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/fetchRestaurantAndFoodItemById/{restaurantId}")
    public ResponseEntity<FoodCataloguePage> fetchrestaurantDetailsWithFoodMenu(@PathVariable int restaurantId) {
        FoodCataloguePage foodCataloguePage =foodCatalogService.fetchFoodCatalogPageDetails(restaurantId);
        return new ResponseEntity<> (foodCataloguePage, HttpStatus.OK);
    }

}
