package com.sop.sopdal.transformer;

import com.sop.sopdal.domain.Order;
import com.sop.sopdal.domain.User;
import com.sop.sopdal.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderTransformer implements Transformer<Order, OrderDTO>{

    @Autowired
    ProductTransformer productTransformer;

    @Override
    public Order toEntity(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setCustomer(new User(orderDTO.getCustomerId()));
        if(orderDTO.getCourierId() != null){
            order.setCourier(new User(orderDTO.getCourierId()));
        }
        order.setProducts(orderDTO.getProducts().stream().map(productTransformer::toEntity).collect(Collectors.toList()));
        order.setAddress(orderDTO.getAddress());
        order.setOrderStatus(orderDTO.getOrderStatus());
        order.setTotal(orderDTO.getTotal());
        return order;
    }

    @Override
    public OrderDTO toDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setCustomerId(order.getCustomer().getId());
        if(order.getCourier() != null) {
            orderDTO.setCourierId(order.getCourier().getId());
        }
        orderDTO.setProducts(order.getProducts().stream().map(productTransformer::toDTO).collect(Collectors.toList()));
        orderDTO.setAddress(order.getAddress());
        orderDTO.setOrderStatus(order.getOrderStatus());
        orderDTO.setTotal(order.getTotal());
        return orderDTO;
    }
}
