package com.sop.sopdal.rest;

import com.sop.sopdal.domain.Order;
import com.sop.sopdal.domain.OrderStatusEnum;
import com.sop.sopdal.domain.User;
import com.sop.sopdal.dto.OrderDTO;
import com.sop.sopdal.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/public/orders")
public class OrderController {

    @Autowired
    OrderService service;

    @GetMapping
    public List<OrderDTO> getAllOrders(){
        return this.service.getAllOrders();
    }

    @GetMapping("/{customer_id}")
    public List<Order> getOrdersByUserId(@PathVariable("customer_id") Long customerId) {
        return this.service.getOrdersByCustomerId(customerId);
    }

    @PostMapping
    public void addOrder(@RequestBody OrderDTO orderDTO){
        this.service.transformAndSaveOrder(orderDTO);
    }

    @PostMapping("/{order_id}")
    public void takeOrder(@PathVariable("order_id") Long orderId, Principal oauth2){
        this.service.takeOrder(orderId, (User)oauth2);
    }
}
