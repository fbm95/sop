package com.sop.sopbackend.service;

import com.sop.sopbackend.config.EmailService;
import com.sop.sopbackend.dto.Order;
import com.sop.sopbackend.dto.Restaurant;
import com.sop.sopbackend.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.sop.sopbackend.constant.RestConstant.ORDER_URL;

@Service
public class OrderService {

    @Autowired
    EmailService emailService;

    @Autowired
    UserService userService;

    private RestTemplate restTemplate = new RestTemplate();

    public List<Order> getAll() {
        return restTemplate.exchange(ORDER_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Order>>() {
        }).getBody();
    }

    public List<Order> getAllOrdersForUser(Long userId) {
        return restTemplate.exchange(ORDER_URL + "/" + userId, HttpMethod.GET, null, new ParameterizedTypeReference<List<Order>>() {
        }).getBody();
    }

    public void save(Order object,String authorization) {
        User user = userService.forwardGetInfoUserReq(authorization);
        try {
            restTemplate.postForEntity(ORDER_URL, object, ResponseEntity.class);
            emailService.sendEmail(user.getEmail(), "Food-Takeaway", "Your command was registered!");

        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public Order takeOrder(Long orderId, String authorization) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorization);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(ORDER_URL+"/"+orderId, HttpMethod.POST, entity, new ParameterizedTypeReference<Order>() {
        }).getBody();
    }
}
