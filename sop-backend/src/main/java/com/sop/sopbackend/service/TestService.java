package com.sop.sopbackend.service;

import com.sop.sopbackend.dto.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.sop.sopbackend.constant.RestConstant.DAL;

@Service
public class TestService {

    private static final String TEST_URL = DAL + "/test";

    private RestTemplate restTemplate = new RestTemplate();

    public List<Test> getAll(){
        return restTemplate.exchange(TEST_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Test>>() {}).getBody();
    }

    public void save(Test object){
        restTemplate.postForEntity(TEST_URL,object, ResponseEntity.class);
    }
}
