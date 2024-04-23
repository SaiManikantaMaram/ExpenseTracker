package com.smani.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

public class OrderRequest {

	private String orderNumber;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderLineItemsDTO> orderLineItemsListDTO;

	public OrderRequest() {
	}

	public OrderRequest(String orderNumber, List<OrderLineItemsDTO> orderLineItemsList) {
		super();
		this.orderNumber = orderNumber;
		this.orderLineItemsListDTO = orderLineItemsList;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public List<OrderLineItemsDTO> getOrderLineItemsList() {
		return orderLineItemsListDTO;
	}

	public void setOrderLineItemsList(List<OrderLineItemsDTO> orderLineItemsList) {
		this.orderLineItemsListDTO = orderLineItemsList;
	}

}
