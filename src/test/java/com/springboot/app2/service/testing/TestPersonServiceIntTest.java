package com.springboot.app2.service.testing;

import com.springboot.app2.entity.testing.TestPerson;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestPersonServiceIntTest {

    @Autowired
    private TestPersonService personService;

    @Autowired
    private TestAddressService addressService;

    @Test
    public void createPersonTest_noAddress() {
        TestPerson person = personService.createPerson(TestUserServiceTest.DUMMY_ID, "James Bond");
        Assertions.assertThat(person).isNull();
    }

}
