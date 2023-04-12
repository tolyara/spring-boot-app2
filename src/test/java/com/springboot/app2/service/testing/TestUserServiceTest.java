package com.springboot.app2.service.testing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestUserServiceTest {

    private TestUserService testUserService;

    @BeforeEach
    public void setup() {
        testUserService = new TestUserService();
    }

    @Test
    public void helloTest() {
        String helloStr = testUserService.hello();

        Assertions.assertThat(helloStr).isNotNull();
        Assertions.assertThat(helloStr).isEqualTo("Hello");
    }

}
