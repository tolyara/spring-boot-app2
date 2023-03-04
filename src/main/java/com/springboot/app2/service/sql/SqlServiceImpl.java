package com.springboot.app2.service.sql;

import com.springboot.app2.dao.EmployeeRepository;
import com.springboot.app2.entity.Employee;
import com.springboot.app2.util.RandomUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
    CREATE INDEX idx_name ON employees(name);
    DROP INDEX idx_name;

    select * from employees order by "name"
    Without index - 6-7 sec
    With index - 1-2 sec
 */

@Service
public class SqlServiceImpl implements SqlService {

    private final int numberOfRecords = 100_000;

    private final EmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public SqlServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void insertToTable() {
        Collection<Employee> employees = new ArrayList<>(numberOfRecords);
        for (int i = 0; i < numberOfRecords; i++) {
            employees.add(new Employee("emp-" + RandomUtil.generateRandomLongValue()));
        }
        employeeRepository.saveAll(employees);
    }

}
