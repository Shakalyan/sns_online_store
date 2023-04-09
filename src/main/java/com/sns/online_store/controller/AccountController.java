package com.sns.online_store.controller;

import com.sns.online_store.dto.RegistrationRequest;
import com.sns.online_store.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/registration")
    public ResponseEntity<String> register(@RequestBody RegistrationRequest request) {
        accountService.register(request);
        return ResponseEntity.ok("ok");
    }

}
