package com.smani.service;

import java.util.List;

import com.smani.model.InventoryResponse;

public interface IInventoryService {
	public List<InventoryResponse> isInStock(List<String> skuCode);
}
