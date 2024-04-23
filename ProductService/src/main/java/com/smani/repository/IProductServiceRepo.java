package com.smani.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smani.model.Product;

@Repository
public interface IProductServiceRepo extends MongoRepository<Product,String> {

}
