package com.sns.online_store.controller;

import com.sns.online_store.model.Order;
import com.sns.online_store.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/order")
    public ResponseEntity<Order> findById(@RequestParam("id") String orderId) {
        return ResponseEntity.ok(orderService.findById(orderId));
    }

    @PostMapping("/orders")
    public ResponseEntity<String> insertOne(@RequestBody Order order) {
        orderService.insertOne(order);
        return ResponseEntity.ok("ok");
    }

    @DeleteMapping("/orders")
    public ResponseEntity<String> deleteById(@RequestParam("id") String orderId) {
        orderService.deleteById(orderId);
        return ResponseEntity.ok("ok");
    }

    @PatchMapping("/orders")
    public ResponseEntity<String> updateOne(@RequestBody Order order) {
        orderService.updateOne(order);
        return ResponseEntity.ok("ok");
    }


}
