package com.sambochhay.simpleonlineshopping.productservice.controllers;

import com.sambochhay.simpleonlineshopping.productservice.dto.ProductReponse;
import com.sambochhay.simpleonlineshopping.productservice.dto.ProductRequest;
import com.sambochhay.simpleonlineshopping.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductReponse> getAllProducts(){
        return productService.getAllProducts();
    }
}
