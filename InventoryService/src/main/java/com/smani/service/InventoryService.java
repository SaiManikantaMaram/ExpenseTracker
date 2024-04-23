package com.smani.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smani.model.Inventory;
import com.smani.model.InventoryResponse;
import com.smani.repository.InventoryRepo;

@Service
public class InventoryService implements IInventoryService {

	@Autowired
	private InventoryRepo ir;

	@Override
	public List<InventoryResponse> isInStock(List<String> skuCode) {

		List<Inventory> inventoryList = ir.findByskuCodeIn(skuCode);

		List<InventoryResponse> inventoryResponseList = inventoryList.stream()
				.map(i -> new InventoryResponse(i.getSkuCode(), i.getQuantity() > 0)).collect(Collectors.toList());
		return inventoryResponseList;

	}

}
