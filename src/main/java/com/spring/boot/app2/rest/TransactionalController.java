package com.spring.boot.app2.rest;

import com.spring.boot.app2.entity.Student;
import com.spring.boot.app2.service.TransactionalService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionalController {

    private final TransactionalService transactionalService;

    public TransactionalController(TransactionalService transactionalService) {
        this.transactionalService = transactionalService;
    }

    @PostMapping("/transactional")
    public Object transactionalExecute(@RequestBody List<Student> students) {
        return transactionalService.updateStudent();
    }

}
