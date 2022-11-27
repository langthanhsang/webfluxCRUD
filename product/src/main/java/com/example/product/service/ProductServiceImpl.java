package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createProduct(Product p) {
         productRepository.save(p);
    }

    @Override
    public Mono<Product> findByProductId(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Flux<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> updateProduct(Product p) {
        return productRepository.save(p);
    }

    @Override
    public Mono<Void> deleteProduct(Integer id) {
        return productRepository.deleteById(id);
    }
}
