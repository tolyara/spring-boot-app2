package com.springboot.app2.service.testing;

import com.springboot.app2.dao.testing.TestPersonRepository;
import com.springboot.app2.entity.testing.TestAddress;
import com.springboot.app2.entity.testing.TestPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestPersonService {

    private final TestPersonRepository personRepository;
    private final TestAddressService addressService;

    @Autowired
    public TestPersonService(TestPersonRepository personRepository, TestAddressService addressService) {
        this.personRepository = personRepository;
        this.addressService = addressService;
    }

    public TestPerson createPerson(Long addressId, String personName) {
        TestAddress address = addressService.findAddress(addressId);
        if (address == null) return null;

        TestPerson newPerson = new TestPerson();
        newPerson.setName(personName);
        newPerson.setAddress(address);
        return personRepository.save(newPerson);
    }

}
