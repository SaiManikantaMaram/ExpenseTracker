package com.smani.service;

import com.smani.dto.ProductRequest;
import com.smani.dto.ProductResponse;

public interface IProductService {
	public String registerProduct(ProductRequest pdr);
	public Iterable<ProductResponse> showAllProducts();

}
