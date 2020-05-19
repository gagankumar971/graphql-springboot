
package com.graphql.app.resolver;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.app.ApplicationStartupRunner;
import com.graphql.app.domain.Item;
import com.graphql.app.repository.ItemRepository;

@Component
public class ItemQuery implements GraphQLQueryResolver {
	private static Logger LOGGER = LoggerFactory.getLogger(ItemQuery.class);
	private ItemRepository itemRepository;

	public ItemQuery(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public Optional<Item> getItemSearch(Integer itemId) {
		LOGGER.info("inside getItemSearch");
		return itemRepository.findById(itemId);
	}
	
	public List<Item> getAllItems() {
		LOGGER.info("inside getAllItems");
		return itemRepository.findAll();
	}

}
