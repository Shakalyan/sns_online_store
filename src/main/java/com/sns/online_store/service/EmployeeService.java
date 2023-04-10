package com.sns.online_store.service;

import com.sns.online_store.dto.RegistrationRequest;
import com.sns.online_store.exception.ApiException;
import com.sns.online_store.exception.BadApiRequestException;
import com.sns.online_store.exception.EntityNotFoundException;
import com.sns.online_store.model.Employee;
import com.sns.online_store.repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleFactory roleFactory;

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
                                             roleFactory.getRolesOf(request.getRole())));
    }

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public Employee findById(Integer employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isEmpty()) {
            throw new EntityNotFoundException(String.format("Employee with id '%s' not found", employeeId));
        }
        return employee.get();
    }

    public void deleteById(Integer employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isEmpty()) {
            throw new EntityNotFoundException(String.format("Employee with id '%s' not found", employeeId));
        }
        employeeRepository.deleteById(employeeId);
    }

}
