package com.sop.sopdal.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestaurantDTO {
    private BigDecimal minOrderValue;
    private String name;
}
