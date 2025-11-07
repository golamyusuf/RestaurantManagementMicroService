package com.golam.restaurantlisting.mapper;

import com.golam.restaurantlisting.dtos.RestaurantDto;
import com.golam.restaurantlisting.entities.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper Instance = Mappers.getMapper(RestaurantMapper.class);

    RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant);
    Restaurant mapRestaurantDtoToRestaurant(RestaurantDto restaurantDto);
}
