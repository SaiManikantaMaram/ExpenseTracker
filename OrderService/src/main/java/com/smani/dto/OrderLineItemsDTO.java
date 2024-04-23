package com.smani.dto;

import java.math.BigDecimal;

import com.smani.model.OrderLineItems;

public class OrderLineItemsDTO {

	private String skucode;
	private BigDecimal price;
	private Integer quantity;

	public OrderLineItemsDTO() {
	}

	public OrderLineItemsDTO(OrderLineItems oli) {

		this.skucode = oli.getSkucode();
		this.price = oli.getPrice();
		this.quantity = oli.getQuantity();
	}

	public OrderLineItemsDTO(Long id, String skucode, BigDecimal price, Integer quantity) {
		super();

		this.skucode = skucode;
		this.price = price;
		this.quantity = quantity;
	}

	public String getSkucode() {
		return skucode;
	}

	public void setSkucode(String skucode) {
		this.skucode = skucode;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
