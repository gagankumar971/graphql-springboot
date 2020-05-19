package com.graphql.app.resolver;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.app.domain.Order;
import com.graphql.app.repository.OrderRepository;
@Component
public class Query implements GraphQLQueryResolver {
    private OrderRepository orderRepository;
    
    public Query(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<Order> getRecentOrders(int count, int offset) {
    	List<Order> orderList = orderRepository.findAll().stream().skip(offset).limit(count).collect(Collectors.toList());
    	return orderList;
    }
    public Optional<Order> getOrderSearch(Integer orderId) {
    	return orderRepository.findById(orderId);
    }
	
}
