package com.smani.model;

import java.math.BigDecimal;

import com.smani.dto.OrderLineItemsDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_order_line_items")
public class OrderLineItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String skucode;
	private BigDecimal price;
	private Integer quantity;

	public OrderLineItems() {

	}

	public OrderLineItems(OrderLineItemsDTO olid) {
		super();
		this.skucode = olid.getSkucode();
		this.price = olid.getPrice();
		this.quantity = olid.getQuantity();
	}

	public OrderLineItems(Long id, String skucode, BigDecimal price, Integer quantity) {
		super();
		this.id = id;
		this.skucode = skucode;
		this.price = price;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
