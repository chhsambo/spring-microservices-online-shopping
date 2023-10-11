package com.sambochhay.simpleonlineshopping.productservice.repositories;

import com.sambochhay.simpleonlineshopping.productservice.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
