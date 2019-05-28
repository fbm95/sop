package com.sop.sopbackend.service;

import com.sop.sopbackend.dto.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.sop.sopbackend.constant.RestConstant.PRODUCT_URL;

@Service
public class ProductService {

    private RestTemplate restTemplate = new RestTemplate();

    public List<Product> getAllProductsFor(Long restaurantId) {
        return restTemplate.exchange(PRODUCT_URL+"?restaurant_id="+restaurantId, HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {
        }).getBody();
    }

    public Product getProductById(Long prodId) {
        return restTemplate.exchange(PRODUCT_URL+"/"+prodId, HttpMethod.GET, null, new ParameterizedTypeReference<Product>() {
        }).getBody();
    }

    public void save(Product object) {
        restTemplate.postForEntity(PRODUCT_URL, object, ResponseEntity.class);
    }
}
