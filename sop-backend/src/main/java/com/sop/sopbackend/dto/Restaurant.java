package com.sop.sopbackend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Restaurant {

    private int id;

    private BigDecimal minOrderValue;

    private String name;
}
