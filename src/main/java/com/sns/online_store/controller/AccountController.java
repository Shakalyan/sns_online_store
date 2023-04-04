package com.sns.online_store.controller;

import com.sns.online_store.dto.RegistrationRequest;
import com.sns.online_store.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/registration")
    public ResponseEntity<String> register(@RequestBody RegistrationRequest request) {
        accountService.register(request);
        return ResponseEntity.ok("ok");
    }

}
