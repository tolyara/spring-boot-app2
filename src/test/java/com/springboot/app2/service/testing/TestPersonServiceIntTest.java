package com.springboot.app2.service.testing;

import com.springboot.app2.entity.testing.TestAddress;
import com.springboot.app2.entity.testing.TestPerson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestPersonServiceIntTest {

    @Autowired
    private TestPersonService personService;

    @Autowired
    private TestAddressService addressService;

    @Test
    public void createPersonTest_noAddress() {
        TestPerson person = personService.createPerson(-1L, "James Bond");
        assertThat(person).isNull();
    }

    @Test
    public void createPersonTest() {
        TestAddress address = addressService.createAddress("a1");
        assertThat(address).isNotNull();

        TestPerson person = personService.createPerson(address.getId(), "James Bond");
        assertThat(person).isNotNull();
        assertThat(person.getAddress()).isNotNull();
        assertThat(person.getAddress().getId()).isEqualTo(address.getId());
    }

}
