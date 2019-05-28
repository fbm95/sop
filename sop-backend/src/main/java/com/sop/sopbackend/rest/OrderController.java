package com.sop.sopbackend.rest;

import com.sop.sopbackend.dto.Order;
import com.sop.sopbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<List<Order>> getAllOrdersForUser(@PathVariable("user_id") Long userId) {
        return ResponseEntity.ok(this.service.getAllOrdersForUser(userId));
    }

    @PutMapping("/{order_id}")
    public ResponseEntity takeOrder(@PathVariable("order_id") Long orderId, @RequestHeader("Authorization") String authorization){
        return ResponseEntity.ok(this.service.takeOrder(orderId, authorization));
    }

    @PostMapping
    public ResponseEntity addOrder(@RequestBody Order object, @RequestHeader("Authorization")String authorization) {
        this.service.save(object, authorization);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
