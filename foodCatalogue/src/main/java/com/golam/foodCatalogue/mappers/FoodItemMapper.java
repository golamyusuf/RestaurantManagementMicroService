package com.golam.foodCatalogue.mappers;
import com.golam.foodCatalogue.dto.FoodItemDto;
import com.golam.foodCatalogue.entities.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {
    FoodItemMapper Instance = Mappers.getMapper(FoodItemMapper.class);

    FoodItemDto foodItemToFoodItemDto(FoodItem FoodItem);
    FoodItem foodItemDtoToFoodItem(FoodItemDto foodItemDto);
}
