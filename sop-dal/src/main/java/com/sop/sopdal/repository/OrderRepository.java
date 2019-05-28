package com.sop.sopdal.repository;

import com.sop.sopdal.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


    List<Order> findAllByCustomer_id(Long customerId);
}
