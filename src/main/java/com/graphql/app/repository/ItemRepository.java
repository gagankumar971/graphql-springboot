package com.graphql.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.graphql.app.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	@Query(value = "select o.orderId from Order o where o.orderId in(?1)")
    List<Integer> findAllOrderIdByOrderId(@Param("orderId") Integer orderId);
	List<Item> findByOrderId(@Param("orderId")Integer orderId);
}