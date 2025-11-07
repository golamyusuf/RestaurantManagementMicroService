package com.golam.restaurantlisting.services;

import com.golam.restaurantlisting.dtos.RestaurantDto;
import com.golam.restaurantlisting.entities.Restaurant;
import com.golam.restaurantlisting.mapper.RestaurantMapper;
import com.golam.restaurantlisting.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    public List<RestaurantDto> findAllRestaurants() {
        List<Restaurant> all = restaurantRepository.findAll();

        List<RestaurantDto> collect = all.stream().map(restaurant -> RestaurantMapper.Instance.mapRestaurantToRestaurantDto(restaurant)).collect(Collectors.toList());
        return collect;
    }

    public RestaurantDto saveRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = RestaurantMapper.Instance.mapRestaurantDtoToRestaurant(restaurantDto);
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return RestaurantMapper.Instance.mapRestaurantToRestaurantDto(savedRestaurant);
    }

    public RestaurantDto findRestauurantById(int id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if(restaurant.isPresent()){
              return RestaurantMapper.Instance.mapRestaurantToRestaurantDto(restaurant.get());
        }
        return null;
    }
}
