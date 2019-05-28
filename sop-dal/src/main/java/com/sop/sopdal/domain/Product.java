package com.sop.sopdal.domain;

import lombok.Data;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @SequenceGenerator(
            name="product_seq",
            sequenceName="product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    private Long id;

    @Column(name = "name")
    @NotNull
    String name;

    @Column(name = "price")
    @NotNull
    BigDecimal price;

    @Column(name = "weight")
    @NotNull
    BigDecimal weight;

    @Column(name = "description")
    @NotNull
    String description;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
    
}
