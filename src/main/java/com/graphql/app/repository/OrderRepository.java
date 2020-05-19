package com.graphql.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.graphql.app.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "select o from Order o where o.orderId in(?1)")
    List<Order> findAllByOrderId(@Param("orderId")List<Integer> orderId);
    
}