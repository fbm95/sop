package com.sop.sopbackend.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Order {

    private Integer id;

    private Long customerId;

    private Long courierId;

    private List<Product> products;

    private String address;

    private BigDecimal total;

    private OrderStatusEnum orderStatus;
}
