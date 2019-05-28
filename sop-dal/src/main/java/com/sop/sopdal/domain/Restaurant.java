package com.sop.sopdal.domain;

import lombok.Data;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "restaurant")
@Data
public class Restaurant {
    @Id
    @SequenceGenerator(
            name="restaurant_seq",
            sequenceName="restaurant_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_seq")
    private Long id;

    @Column(name = "min_order_value")
    @NotNull
    private BigDecimal minOrderValue;

    @Column(name = "name")
    @NotNull
    private String name;
}
