package com.graphql.app.resolver;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.app.domain.InputItem;
import com.graphql.app.domain.Order;
import com.graphql.app.repository.ItemRepository;
import com.graphql.app.repository.OrderRepository;
@Component
public class Mutation implements GraphQLMutationResolver {
	private static Logger LOGGER = LoggerFactory.getLogger(Mutation.class);
	private OrderRepository orderRepository;
	private ItemRepository itemRepository;

	public Mutation(OrderRepository orderRepository, ItemRepository itemRepository) {
		this.orderRepository = orderRepository;
		this.itemRepository = itemRepository;
	}

	public Order feedOrder(Integer orderId, String orderNumber, String orderTitle, String orderText,
			String orderCategory, Character orderStatus, Double orderTotal, List<InputItem> items) {
		LOGGER.info("inside feedOrder");
		Order order = Order.builder()
					  .orderId(orderId)
					  .orderNumber(orderNumber)
					  .orderTitle(orderTitle)
					  .orderText(orderText)
					  .orderCategory(orderCategory)
					  .orderStatus(orderStatus)
					  .orderTotal(orderTotal).build();

		order = orderRepository.save(order);
		items = items.stream().map(item -> {
			item.setOrderId(orderId);
			return item;
		}).collect(Collectors.toList());
		itemRepository.saveAll(items);
		return order;
	}
}