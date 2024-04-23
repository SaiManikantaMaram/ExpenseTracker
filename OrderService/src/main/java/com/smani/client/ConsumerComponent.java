package com.smani.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smani.dto.InventoryResponse;

@FeignClient("InventoryService")
public interface ConsumerComponent {
	@RequestMapping(method = RequestMethod.GET, value = "/api/inventory")
	public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode);

}
