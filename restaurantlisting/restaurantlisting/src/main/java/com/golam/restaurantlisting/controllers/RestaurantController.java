package com.golam.restaurantlisting.controllers;

import com.golam.restaurantlisting.dtos.RestaurantDto;
import com.golam.restaurantlisting.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDto>> fetchAllRestaurants() {

        List<RestaurantDto> listRestaurants = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(listRestaurants, HttpStatus.OK);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDto> addRestaurant(@RequestBody RestaurantDto restaurantDto) {
        RestaurantDto restaurantDtoSaved = restaurantService.saveRestaurant(restaurantDto);
        return new ResponseEntity<>( restaurantDtoSaved, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<RestaurantDto> findById(@PathVariable("id") int id) {
        // Implementation for finding a restaurant by ID would go here
        RestaurantDto restauurantById = restaurantService.findRestauurantById(id);
        if (restauurantById != null) {
            return new ResponseEntity<>(restauurantById, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
