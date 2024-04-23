package com.smani.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.smani.client.ConsumerComponent;
import com.smani.dto.InventoryResponse;
import com.smani.dto.OrderLineItemsDTO;
import com.smani.dto.OrderRequest;
import com.smani.model.Order;
import com.smani.model.OrderLineItems;
import com.smani.repository.IOrderRepo;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private IOrderRepo ior;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Autowired
	private ConsumerComponent cc;

	@Override
	public String placeOrder(OrderRequest or) {

		List<OrderLineItems> OrderLineItems = new ArrayList<>();
		List<String> skuCodes = new ArrayList<>();
		for (OrderLineItemsDTO olit : or.getOrderLineItemsList()) {
			OrderLineItems.add(new OrderLineItems(olit));
			skuCodes.add(olit.getSkucode());
		}

		Order o = new Order(or.getOrderNumber(), OrderLineItems);

		List<InventoryResponse> ir = cc.isInStock(skuCodes);
		/*
		 * webClientBuilder.build().get() .uri("http://InventoryService/api/inventory",
		 * uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
		 * .retrieve().bodyToMono(InventoryResponse[].class).block();
		 */

		Boolean b = ir.stream().allMatch(InventoryResponse::isInStock);
		if (b && ir.size() != 0) {
			ior.save(o);
			return "Order with Order Number: " + o.getOrderNumber() + " is placed";
		} else {
			throw new IllegalArgumentException("Product is not in stock! Please try ordering after few days");
		}

	}

}
