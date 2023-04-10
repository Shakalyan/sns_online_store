package com.sns.online_store.controller;

import com.sns.online_store.dto.RegistrationRequest;
import com.sns.online_store.model.Employee;
import com.sns.online_store.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/registration")
    public ResponseEntity<String> register(@RequestBody RegistrationRequest request) {
        employeeService.register(request);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/employee")
    public ResponseEntity<Employee> findById(@RequestParam("id") Integer employeeId) {
        return ResponseEntity.ok(employeeService.findById(employeeId));
    }

    @DeleteMapping("/employees")
    public ResponseEntity<String> deleteById(@RequestParam("id") Integer employeeId) {
        employeeService.deleteById(employeeId);
        return ResponseEntity.ok("ok");
    }

}
