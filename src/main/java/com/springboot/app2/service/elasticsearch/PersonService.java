package com.springboot.app2.service.elasticsearch;

import com.springboot.app2.entity.elasticsearch.Person;

public interface PersonService {

    void save(Person person);

    Person findById(String id);

}
