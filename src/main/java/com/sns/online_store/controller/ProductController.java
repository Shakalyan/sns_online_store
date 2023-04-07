package com.sns.online_store.controller;

import com.sns.online_store.model.Product;
import com.sns.online_store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<Product> findById(@RequestParam("id") String objectId) {
        return ResponseEntity.ok(productService.findById(objectId));
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping("/products")
    public ResponseEntity<String> insertOne(@RequestBody Product product) {
        productService.insertOne(product);
        return ResponseEntity.ok("ok");
    }

    @DeleteMapping("/products")
    public ResponseEntity<String> deleteById(@RequestParam("id") String objectId) {
        productService.deleteById(objectId);
        return ResponseEntity.ok("ok");
    }

    @PatchMapping("/products")
    public ResponseEntity<String> updateOne(@RequestBody Product product) {
        productService.updateOne(product);
        return ResponseEntity.ok("ok");
    }

}
