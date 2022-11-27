package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {
@Autowired
    private ProductService productService;

    @PostMapping("/create/pro")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPro(@RequestBody Product product) {
        productService.createProduct(product);
    }

    @GetMapping("/get/all")
    @ResponseBody
    public Flux<Product> findAll(){
        Flux<Product> products = productService.findAllProduct();
        return productService.findAllProduct();
    }

    @GetMapping("/get/{id}")

    public ResponseEntity<Mono<Product>>findById(@PathVariable("id") Integer id){
        Mono<Product> product = productService.findByProductId(id);
        return new ResponseEntity<Mono<Product>>(product, product != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);

    }

    @PutMapping("/update/pro")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Product> update(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id){
        productService.deleteProduct(id);
    }

}
