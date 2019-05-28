package com.sop.sopdal.service;

import com.sop.sopdal.domain.Product;
import com.sop.sopdal.domain.Restaurant;
import com.sop.sopdal.dto.RestaurantDTO;
import com.sop.sopdal.repository.RestaurantRepository;
import com.sop.sopdal.transformer.RestaurantTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    @Autowired
    private RestaurantTransformer transformer;

    public List<Restaurant> getAll() {
        return this.repository.findAll();
    }

    public Restaurant transformAndSave(RestaurantDTO dto) {
        return this.save(this.transformer.toEntity(dto));
    }

    public Restaurant save(Restaurant entity) {
        return this.repository.save(entity);
    }
}
