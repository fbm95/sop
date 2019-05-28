package com.sop.sopbackend.service;

import com.sop.sopbackend.dto.Product;
import com.sop.sopbackend.dto.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import static com.sop.sopbackend.constant.RestConstant.DAL;
import static com.sop.sopbackend.constant.RestConstant.RESTAURANT_URL;

@Service
public class RestaurantService {

    private RestTemplate restTemplate = new RestTemplate();

    public List<Restaurant> getAll() {
        return restTemplate.exchange(RESTAURANT_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Restaurant>>() {
        }).getBody();
    }

    public void save(Restaurant object) {
        restTemplate.postForEntity(RESTAURANT_URL, object, ResponseEntity.class);
    }
}
