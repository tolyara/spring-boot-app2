package com.springboot.app2.rest;

import com.springboot.app2.service.sql.SqlService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SqlController {

    private final SqlService sqlService;

    public SqlController(SqlService sqlService) {
        this.sqlService = sqlService;
    }

    @PostMapping("/sql")
    public void testHibernateSave() {
        sqlService.insertToTable();
    }

}
