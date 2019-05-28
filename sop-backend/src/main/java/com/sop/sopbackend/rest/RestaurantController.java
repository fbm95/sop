package com.sop.sopbackend.rest;

import com.sop.sopbackend.dto.Product;
import com.sop.sopbackend.dto.Restaurant;
import com.sop.sopbackend.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService service;

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        return ResponseEntity.ok(this.service.getAll());
    }

    @PostMapping
    public ResponseEntity addRestaurant(@RequestBody Restaurant object) {
        this.service.save(object);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
