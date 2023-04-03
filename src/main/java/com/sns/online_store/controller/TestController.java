package com.sns.online_store.controller;

import com.sns.online_store.model.Employee;
import com.sns.online_store.repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final EmployeeRepository employeeRepository;

    @GetMapping("/test")
    public List<Employee> test() {
        List<Employee> response = new ArrayList<>();
        employeeRepository.findAll().forEach(response::add);
        return response;
    }

}
