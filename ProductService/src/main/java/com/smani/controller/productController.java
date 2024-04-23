package com.smani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.smani.dto.ProductRequest;
import com.smani.dto.ProductResponse;
import com.smani.service.IProductService;

@RestController
@RequestMapping("/api/product")
public class productController {

	@Autowired
	private IProductService ps;

	@PostMapping("/add")
	public ResponseEntity<String> createProduct(@RequestBody ProductRequest pdr) {
		String str = ps.registerProduct(pdr);
		return new ResponseEntity<>(str, HttpStatus.CREATED);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<ProductResponse> getAllProducts()
	{
		return ps.showAllProducts();
	}
	

}
