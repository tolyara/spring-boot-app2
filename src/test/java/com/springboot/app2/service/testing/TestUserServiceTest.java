package com.springboot.app2.service.testing;

import com.springboot.app2.dto.testing.TestUserDto;
import com.springboot.app2.enums.testing.TestUserType;
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
    public void getAllUsersNamesTest() {
        final List<String> names = testUserService.getAllUserNames();

        assertThat(names).hasSize(3)
                .startsWith("James Bond")
                .doesNotContainNull().doesNotContain("Hello")
                .containsAnyOf("James Bond", "QWERTY")
                .containsExactly("James Bond", "Frank Castle", "T Pain")
                .containsExactlyInAnyOrder("Frank Castle", "James Bond", "T Pain")
                .contains("Frank Castle");

        assertThat("T Pain").isIn(names);
    }

    @Test
    public void getAllUsersTest() {
        final List<TestUserDto> allUsers = testUserService.getAllUsers();

        assertThat(allUsers).hasSize(3)
                .extracting(TestUserDto::getName)
                .containsExactly("James Bond", "Frank Castle", "T Pain");

        assertThat(allUsers).hasSize(3)
                .extracting(TestUserDto::getAge)
                .allMatch(age -> age > 20);

        final List<TestUserDto> allUsersCopy = List.of(allUsers.get(1), allUsers.get(0), allUsers.get(2));

        assertThat(allUsers).hasSameElementsAs(allUsersCopy);
    }

    @Test
    public void getAllAdminOrModeratorUsersTest() {
        final List<TestUserDto> allAdminOrModeratorUsers = testUserService.getAllAdminOrModeratorUsers();

        assertThat(allAdminOrModeratorUsers).hasSize(2)
                .extracting(TestUserDto::getTestUserType)
                .containsExactlyInAnyOrder(TestUserType.ADMIN, TestUserType.MODERATOR);
    }

    @Test
    public void withDescriptionTest() {
        final TestUserDto user = testUserService.getAllUsers().get(0);

        assertThat(user.getAge())
                .as("Checking the age of user with name %s failed", user.getName())
                .isEqualTo(45);
    }

    @Test
    public void withFailMessageTest() {
        final TestUserDto user = testUserService.getAllUsers().get(0);

        final int expectedAge = 21;
        assertThat(user.getAge())
                .withFailMessage("Should be %s", expectedAge)
                .isEqualTo(expectedAge);
    }

    @Test
    public void exceptionsTest() {
        assertThatThrownBy(() -> {
            testUserService.getAllUsers().get(55);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index 55")
                .hasMessage("Index 55 out of bounds for length 3")
                .hasMessageStartingWith("Index 55 out")
                .hasMessageEndingWith("length 3")
                .hasStackTraceContaining("java.lang.ArrayIndexOutOfBoundsException:");

        assertThatCode(() -> {
            testUserService.getAllUsers().get(1);
        }).doesNotThrowAnyException();
    }

}
