package com.sop.sopdal.dto;

import com.sop.sopdal.domain.OrderStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDTO {

    private Long id;
    private Long customerId;
    private Long courierId;
    List<ProductDTO> products;
    private String address;
    private BigDecimal total;
    private OrderStatusEnum orderStatus;

}
