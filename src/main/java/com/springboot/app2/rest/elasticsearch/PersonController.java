package com.springboot.app2.rest.elasticsearch;

import com.springboot.app2.entity.elasticsearch.Person;
import com.springboot.app2.service.elasticsearch.PersonService;
import org.springframework.web.bind.annotation.*;

/**
 *  http://localhost:9200/_cat/indices
 *  http://localhost:9200/person?pretty=true
 *  http://localhost:9200/person/_search?pretty=true
 */

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void save(@RequestBody Person person) {
        personService.save(person);
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable String id) {
        return personService.findById(id);
    }

}
