package com.springboot.app2.service.elasticsearch;

//import com.springboot.app2.dao.elasticsearch.PersonRepository;
import com.springboot.app2.entity.elasticsearch.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

//    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl() {
//    public PersonServiceImpl(PersonRepository personRepository) {
//        this.personRepository = personRepository;
    }

    public void save(final Person person) {
//        personRepository.save(person);
    }

    public Person findById(final String id) {
//        return personRepository.findById(id).orElse(null);
        return null;
    }

}
