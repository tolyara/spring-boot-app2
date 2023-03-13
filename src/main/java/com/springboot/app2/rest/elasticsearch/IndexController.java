package com.springboot.app2.rest.elasticsearch;

import com.springboot.app2.entity.elasticsearch.Vehicle;
import com.springboot.app2.service.elasticsearch.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {

    private final IndexService indexService;

    @Autowired
    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @PostMapping("/recreate")
    public void recreateAllIndices(@RequestBody Vehicle vehicle) {
        indexService.recreateIndices();
    }

}
