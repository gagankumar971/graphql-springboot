package com.graphql.app.resolver;

import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphql.app.domain.Item;
import com.graphql.app.repository.ItemRepository;

@Service
public class ItemResolver implements GraphQLResolver<Item> {
	private ItemRepository itemRepository;

	public ItemResolver(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

}