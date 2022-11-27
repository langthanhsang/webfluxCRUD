package com.example.product.service;

import com.example.product.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

   void  createProduct(Product p);

    Mono<Product>findByProductId(Integer id);

    Flux<Product>findAllProduct();

    Mono<Product> updateProduct(Product p);

    Mono<Void> deleteProduct(Integer id);
}
