package com.sop.sopbackend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    private int id;

    String name;

    BigDecimal price;

    BigDecimal weight;

    String description;

    private Restaurant restaurant;
    
}
