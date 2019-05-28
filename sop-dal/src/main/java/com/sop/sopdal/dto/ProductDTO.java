package com.sop.sopdal.dto;

import com.sop.sopdal.domain.Restaurant;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    Long id;
    String name;
    BigDecimal price;
    BigDecimal weight;
    String description;
    private Restaurant restaurant;
}
