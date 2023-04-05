package com.sns.online_store.service;

import com.sns.online_store.dto.RegistrationRequest;
import com.sns.online_store.exception.ApiException;
import com.sns.online_store.exception.BadApiRequestException;
import com.sns.online_store.model.Employee;
import com.sns.online_store.repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(RegistrationRequest request) throws ApiException {
        Optional<Employee> employee = employeeRepository.findByUsername(request.getUsername());
        if (employee.isPresent()) {
            throw new BadApiRequestException("Username is already taken");
        }

        employeeRepository.save(new Employee(0,
                                             request.getUsername(),
                                             passwordEncoder.encode(request.getPassword()),
                                             request.getName(),
                                             request.getEmail(),
                                             request.getPhoneNumber(),
                                             request.getRole()));
    }

}
