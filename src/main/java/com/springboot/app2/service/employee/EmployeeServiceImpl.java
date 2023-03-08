package com.springboot.app2.service.employee;

import com.springboot.app2.dao.EmployeeRepository;
import com.springboot.app2.entity.Employee;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int count = 25;

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Async
    public CompletableFuture<List<Employee>> getEmployeesByNameAsync(String name, Integer count) {
        List<String> namesToFind = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            namesToFind.add("emp-" + i);
        }

        List<Employee> employees = this.getEmployeesByName(namesToFind);
        return CompletableFuture.completedFuture(employees);
    }

    public List<Employee> getEmployeesByName(Collection<String> names) {
        List<Employee> result = new ArrayList<>();
        for (String name : names) {
            List<Employee> employees = employeeRepository.findAllByName(name);
            result.addAll(employees);
        }
        return result;
    }

}
