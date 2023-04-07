package com.sns.online_store.controller;

import com.sns.online_store.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/test")
    public List<Product> test() {
        return null;
    }

}
