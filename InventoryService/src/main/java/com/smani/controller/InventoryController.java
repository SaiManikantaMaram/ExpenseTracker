package com.smani.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.smani.model.InventoryResponse;
import com.smani.service.IInventoryService;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {

	@Autowired
	private IInventoryService iis;

	/*
	 * @GetMapping("/{sku-code}")
	 * 
	 * @ResponseStatus(HttpStatus.OK) public boolean
	 * isInStock(@PathVariable("sku-code") String skuCode) { return
	 * iis.isInStock(skuCode);
	 * 
	 * }
	 */

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
		return iis.isInStock(skuCode);

	}

}
