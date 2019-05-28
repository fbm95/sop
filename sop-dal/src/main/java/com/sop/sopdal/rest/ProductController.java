package com.sop.sopdal.rest;

import com.sop.sopdal.domain.Product;
import com.sop.sopdal.dto.ProductDTO;
import com.sop.sopdal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public/products")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping
    public void addProduct(@RequestBody ProductDTO dto){
        this.service.transformAndSave(dto);
    }

    @GetMapping()
    public List<Product> getAllProductForRestaurant(@RequestParam("restaurant_id") Long restaurantId) {
        return this.service.getAllProductsFor(restaurantId);
    }

    @GetMapping("/{product_id}")
    public Product getAllProductById(@PathVariable("product_id") Long productId) {
        return this.service.getProductById(productId);
    }
}
