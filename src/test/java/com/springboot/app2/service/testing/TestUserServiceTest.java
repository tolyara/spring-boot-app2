package com.springboot.app2.service.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TestUserServiceTest {

    private TestUserService testUserService;

    @BeforeEach
    public void setup() {
        testUserService = new TestUserService();
    }

    @Test
    public void helloTest() {
        String helloStr = testUserService.hello();

        assertThat(helloStr).isNotNull();
        assertThat(helloStr).isEqualTo("Hello");
    }

    @Test
    public void getAllUsersTest() {
        final List<String> names = testUserService.getAllUserNames();

        assertThat(names).hasSize(3)
                .startsWith("James Bond")
                .doesNotContainNull().doesNotContain("Hello")
                .containsAnyOf("James Bond", "QWERTY")
                .containsExactly("James Bond", "Frank Castle", "T Pain")
                .containsExactlyInAnyOrder("Frank Castle", "James Bond", "T Pain")
                .contains("Frank Castle");
    }

}
