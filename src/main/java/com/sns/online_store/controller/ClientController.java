package com.sns.online_store.controller;

import com.sns.online_store.model.Client;
import com.sns.online_store.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/client")
    public ResponseEntity<Client> findById(@RequestParam("id") String clientId) {
        return ResponseEntity.ok(clientService.findById(clientId));
    }

    @PostMapping("/clients")
    public ResponseEntity<String> insertOne(@RequestBody Client client) {
        clientService.insertOne(client);
        return ResponseEntity.ok("ok");
    }

    @DeleteMapping("/clients")
    public ResponseEntity<String> deleteById(@RequestParam("id") String clientId) {
        clientService.deleteById(clientId);
        return ResponseEntity.ok("ok");
    }

    @PatchMapping("/clients")
    public ResponseEntity<String> updateOne(@RequestBody Client client) {
        clientService.updateOne(client);
        return ResponseEntity.ok("ok");
    }

}
