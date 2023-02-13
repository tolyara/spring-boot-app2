package com.springboot.app2.rest;

import com.springboot.app2.service.TransactionalService;
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
    public Object transactionalExecute(@RequestBody List<Object> students) {
        return transactionalService.updateStudent();
    }

}
