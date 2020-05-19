package com.graphql.app.resolver;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphql.app.domain.Item;
import com.graphql.app.domain.Order;
import com.graphql.app.repository.ItemRepository;
import com.graphql.app.repository.OrderRepository;

@Service
public class OrderResolver implements GraphQLResolver<Order> {
	private static Logger LOGGER = LoggerFactory.getLogger(OrderResolver.class);
	private ItemRepository itemRepository;
	//private OrderRepository orderRepository;

	public OrderResolver(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public List<Item> getItems(Order order) {
		LOGGER.info("inside getOrderId >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + order.getOrderId());
		List<Item> items = itemRepository.findByOrderId(order.getOrderId());
		return items;
	}

}