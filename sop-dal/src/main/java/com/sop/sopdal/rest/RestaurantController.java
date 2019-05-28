package com.sop.sopdal.rest;

import com.sop.sopdal.domain.Product;
import com.sop.sopdal.domain.Restaurant;
import com.sop.sopdal.dto.RestaurantDTO;
import com.sop.sopdal.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService service;

    @GetMapping
    public List<Restaurant> getAllRestaurants (){
        return this.service.getAll();
    }

    @PostMapping
    public void addRestaurant(@RequestBody RestaurantDTO dto){
        this.service.transformAndSave(dto);
    }
}
