package com.sop.sopdal.service;

import com.sop.sopdal.domain.Order;
import com.sop.sopdal.domain.OrderStatusEnum;
import com.sop.sopdal.domain.User;
import com.sop.sopdal.dto.OrderDTO;
import com.sop.sopdal.repository.OrderRepository;
import com.sop.sopdal.transformer.OrderTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductService productService;
    @Autowired
    OrderTransformer transformer;

    public List<OrderDTO> getAllOrders(){
        return this.orderRepository.findAll().stream().map(transformer::toDTO).collect(Collectors.toList());
    }

    public List<Order> getOrdersByCustomerId(Long customerId) {
        return this.orderRepository.findAllByCustomer_id(customerId);
    }

    public Order transformAndSaveOrder(OrderDTO orderDTO){
        Order order = this.transformer.toEntity(orderDTO);
        order.setTotal(productService.computeTotalForProductsIn(orderDTO.getProducts()));
        order.setOrderStatus(OrderStatusEnum.PENDING);
        return this.addOrder(order);
    }

    private Order addOrder(Order order){
        return this.orderRepository.save(order);
    }

    public Order takeOrder(Long orderId, User user){
        Order order = this.getOrderById(orderId);
        order.setOrderStatus(OrderStatusEnum.DELIVERING);
        order.setCourier(user);
        return this.orderRepository.save(order);
    }

    public Order getOrderById(Long orderId){
        return this.orderRepository.getOne(orderId);
    }
}
