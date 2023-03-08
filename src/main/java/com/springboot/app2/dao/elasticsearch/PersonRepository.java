package com.springboot.app2.dao.elasticsearch;

import com.springboot.app2.entity.elasticsearch.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
//import org.springframework.stereotype.Repository;

//@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, String> {



}
