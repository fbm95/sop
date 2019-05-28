package com.sop.sopdal.repository;

import com.sop.sopdal.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByRestaurantId(Long restaurantId);

    Product findProductById(Long productId);

    @Query(value = "select sum(price) from product where id in :id_list",nativeQuery = true)
    BigDecimal totalSumForProducts(@Param("id_list") List<Long> idList);
}

