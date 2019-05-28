package com.sop.sopdal.transformer;

import com.sop.sopdal.domain.Restaurant;
import com.sop.sopdal.dto.RestaurantDTO;
import org.springframework.stereotype.Component;

@Component
public class RestaurantTransformer implements Transformer<Restaurant, RestaurantDTO> {

    @Override
    public Restaurant toEntity(RestaurantDTO restaurantDTO) {
        Restaurant entity = new Restaurant();
        entity.setMinOrderValue(restaurantDTO.getMinOrderValue());
        entity.setName(restaurantDTO.getName());
        return entity;
    }

    @Override
    public RestaurantDTO toDTO(Restaurant restaurant) {
        RestaurantDTO dto = new RestaurantDTO();
        dto.setMinOrderValue(restaurant.getMinOrderValue());
        dto.setName(restaurant.getName());
        return dto;
    }
}
