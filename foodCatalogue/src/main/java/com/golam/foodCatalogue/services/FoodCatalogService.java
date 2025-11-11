package com.golam.foodCatalogue.services;

import com.golam.foodCatalogue.dto.FoodCataloguePage;
import com.golam.foodCatalogue.dto.FoodItemDto;
import com.golam.foodCatalogue.dto.Restaurant;
import com.golam.foodCatalogue.entities.FoodItem;
import com.golam.foodCatalogue.mappers.FoodItemMapper;
import com.golam.foodCatalogue.repositories.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogService {
    @Autowired
    FoodItemRepository foodItemRepository;

    @Autowired
    RestTemplate restTemplate;

    public FoodItemDto addFoodItem(FoodItemDto foodItemDto) {
        FoodItem savedFoodItem = foodItemRepository.save(FoodItemMapper.Instance.foodItemDtoToFoodItem(foodItemDto));
        return FoodItemMapper.Instance.foodItemToFoodItemDto(savedFoodItem);
    }

    public FoodCataloguePage fetchFoodCatalogPageDetails(int restaurantId) {
        List<FoodItem> listFoodItem = fetchFooodItemListByRestaurantId(restaurantId);
        Restaurant restaurant = fetchRestaurantDetailsById(restaurantId);
        return createfoodCataloguePage(listFoodItem, restaurant);
    }

    private FoodCataloguePage createfoodCataloguePage(List<FoodItem> listFoodItem, Restaurant restaurant) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setRestaurant(restaurant);
        foodCataloguePage.setFoodItemList(listFoodItem);
        return foodCataloguePage;
    }

    private List<FoodItem> fetchFooodItemListByRestaurantId(int restaurantId) {
       return foodItemRepository.findByRestaurantId(restaurantId);
    }

    private Restaurant fetchRestaurantDetailsById(int restaurantId) {
        Restaurant forObject = restTemplate.getForObject("http://RESTAURANTLISTING/restaurants/findById/" + restaurantId, Restaurant.class);
        return forObject;
    }
}
