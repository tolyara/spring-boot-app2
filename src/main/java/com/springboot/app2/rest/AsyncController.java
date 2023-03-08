package com.springboot.app2.rest;

import com.springboot.app2.service.employee.EmployeeService;
import com.springboot.app2.util.LoggingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RestController
public class AsyncController {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final EmployeeService employeeService;

    public AsyncController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/async/{count}")
    public Object getEmployeesByNameListAsync(@PathVariable Integer count) {
        Object result = null;
        try {
//            result = employeeService.getEmployeesByNameAsync("").get(5, TimeUnit.SECONDS);
            result = employeeService.getEmployeesByNameAsync("", count).get();
            return result;
        } catch (InterruptedException | ExecutionException e) {
            logger.error("{} exception occured, {}", LoggingUtil.APP, e);
            return result;
        }
//        catch (TimeoutException e) {
//            logger.error("{} exception occured, {}", LoggingUtil.APP, e);
//            return result;
//        }
    }

}
