package com.graphql.app;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.graphql.app.domain.Item;
import com.graphql.app.domain.Order;
import com.graphql.app.repository.ItemRepository;
import com.graphql.app.repository.OrderRepository;

@Component
public class ApplicationStartupRunner implements CommandLineRunner {
	private static Logger LOGGER = LoggerFactory.getLogger(ApplicationStartupRunner.class);
	
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private OrderRepository orderDetailRepository;
    
    @Override
    public void run(String... args) throws Exception {
    	
    	List<Order> orders = new ArrayList<>();
    	List<Item> items = new ArrayList<>();
        LOGGER.info("ApplicationStartupRunner ----------------");
		
        for (int orderId = 1; orderId < 10; orderId++) {
			
			  	Double orderTotal = new Double("0.0");
	    		for (int itemId = (orderId*10); itemId < (orderId*10)+10; ++itemId) {
	    			Double itemPrice = new Double(itemId + "0.0");
	    			Long companyId = 0L;
					
	                if(itemId % 2 == 0) {
	                	companyId = Long.valueOf("2000");
	                }else if(itemId % 3 == 0) {
	                	companyId = Long.valueOf("3000");
	                }else if(itemId % 5 == 0) {
	                	companyId = Long.valueOf("5000");
	                }
	                Item item = Item
	                		.builder()
	                		.itemId(itemId)
	                		.itemNumber("IT" + itemId)
			                .itemName("Item " + String.valueOf(itemId))	
			                .itemStatus('A')
			                .thumbnail("http://example.com/items/" + itemId)
			                .orderId(orderId)
			                .itemPrice(Double.valueOf(itemId)).build();
			            	orderTotal = orderTotal + itemPrice;
			            	items.add(item);
        }
	    		Order order = Order.builder()
				  .orderId(orderId)
				  .orderNumber("ORD " + orderId)
				  .orderTitle("Title " + orderId + ":" + orderId)
				  .orderText("Order " + orderId + " + by company ")
				  .orderCategory("Category")
				  .orderStatus('A')	
				  .orderTotal(orderTotal).build();
	    orders.add(order);
                
        }
        itemRepository.saveAll(items);
        orderDetailRepository.saveAll(orders);
   }
}
