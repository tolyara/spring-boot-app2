package com.springboot.app2.service.employee;

import com.springboot.app2.entity.Employee;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface EmployeeService {

    CompletableFuture<List<Employee>> getEmployeesByNameAsync(String name, Integer count);

}
