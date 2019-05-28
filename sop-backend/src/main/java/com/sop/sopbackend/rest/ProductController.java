package com.sop.sopbackend.rest;

import com.sop.sopbackend.dto.Product;
import com.sop.sopbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping
    public ResponseEntity addProduct(@RequestBody Product object) {
        this.service.save(object);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProductsForRestaurant(@RequestParam("restaurant_id") Long restaurantId) {
        return ResponseEntity.ok(this.service.getAllProductsFor(restaurantId));
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<Product> getProductById(@PathVariable("product_id") Long productId) {
        return ResponseEntity.ok(this.service.getProductById(productId));
    }
}
