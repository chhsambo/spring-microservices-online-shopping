package com.sambochhay.simpleonlineshopping.productservice.services;

import com.sambochhay.simpleonlineshopping.productservice.dto.ProductReponse;
import com.sambochhay.simpleonlineshopping.productservice.dto.ProductRequest;
import com.sambochhay.simpleonlineshopping.productservice.models.Product;
import com.sambochhay.simpleonlineshopping.productservice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductReponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductReponse).toList();
    }

    private ProductReponse mapToProductReponse(Product product) {
        return  ProductReponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
