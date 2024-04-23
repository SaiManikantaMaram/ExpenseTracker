package com.smani.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smani.dto.ProductRequest;
import com.smani.dto.ProductResponse;
import com.smani.model.Product;
import com.smani.repository.IProductServiceRepo;

@Service("product-service")
public class ProductService implements IProductService {

	@Autowired
	private IProductServiceRepo pdr;

	@Override
	public String registerProduct(ProductRequest pro) {
		Product pr = new Product(pro.getName(), pro.getDescription(), pro.getPrice());
		pdr.save(pr);
		return "Product:" + pr.getId() + "Registered Successfully";
	}

	@Override
	public Iterable<ProductResponse> showAllProducts() {

		List<Product> pr = pdr.findAll();
		return pr.stream().map(product -> mapToProductResponse(product)).collect(Collectors.toList());
	}

	private ProductResponse mapToProductResponse(Product product) {
		return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
	}

}
