package com.springboot.app2.service.testing;

import com.springboot.app2.dto.testing.TestUserDto;
import com.springboot.app2.dto.testing.TestUserInfoDto;
import com.springboot.app2.enums.testing.TestUserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class TestUserServiceTest {

    private final String dummyId = "not-there";

    private TestUserService testUserServiceWithMock;
    private TestUserService testUserServiceWithSpy;

//    @Mock
    private TestUserInfoService testUserInfoServiceMock;
    private TestUserInfoService testUserInfoServiceSpy;

    @BeforeEach
    public void setup() {
        testUserInfoServiceMock = mock(TestUserInfoService.class);
        testUserInfoServiceSpy = spy(new TestUserInfoService());

        doAnswer(a -> {
            String userId = a.getArgument(0);
            if (userId.equals(dummyId)) {
                return null;
            }

            return new TestUserInfoDto("1", "A", "n");
//            return TestUserProvider.getUserInfo(userId);
        }).when(testUserInfoServiceMock).getUserInfo(anyString());

        testUserServiceWithMock = new TestUserService(testUserInfoServiceMock);
        testUserServiceWithSpy = new TestUserService(testUserInfoServiceSpy);
    }

    @Test
    public void helloTest() {
        String helloStr = testUserServiceWithMock.hello();

        assertThat(helloStr).isNotNull();
        assertThat(helloStr).isEqualTo("Hello");
    }

    @Test
    public void getAllUsersNamesTest() {
        final List<String> names = testUserServiceWithMock.getAllUserNames();

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
        final List<TestUserDto> allUsers = testUserServiceWithMock.getAllUsers();

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
        final List<TestUserDto> allAdminOrModeratorUsers = testUserServiceWithMock.getAllAdminOrModeratorUsers();

        assertThat(allAdminOrModeratorUsers).hasSize(2)
                .extracting(TestUserDto::getTestUserType)
                .containsExactlyInAnyOrder(TestUserType.ADMIN, TestUserType.MODERATOR);
    }

//    @Test
    public void withDescriptionTest() {
        final TestUserDto user = testUserServiceWithMock.getAllUsers().get(0);

        assertThat(user.getAge())
                .as("Checking the age of user with name %s failed", user.getName())
                .isEqualTo(45);
    }

    @Test
    public void withFailMessageTest() {
        final TestUserDto user = testUserServiceWithMock.getAllUsers().get(0);

        final int expectedAge = 21;
        assertThat(user.getAge())
                .withFailMessage("Should be %s", expectedAge)
                .isEqualTo(expectedAge);
    }

    @Test
    public void exceptionsTest() {
        assertThatThrownBy(() -> {
            testUserServiceWithMock.getAllUsers().get(55);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index 55")
                .hasMessage("Index 55 out of bounds for length 3")
                .hasMessageStartingWith("Index 55 out")
                .hasMessageEndingWith("length 3")
                .hasStackTraceContaining("java.lang.ArrayIndexOutOfBoundsException:");

        assertThatCode(() -> {
            testUserServiceWithMock.getAllUsers().get(1);
        }).doesNotThrowAnyException();
    }

    @Test
    public void getUserInfosTest_NoUserIds() {
        assertThat(testUserServiceWithMock.getUserInfos(null)).isEmpty();
        assertThat(testUserServiceWithMock.getUserInfos(new ArrayList<>())).isEmpty();
    }

    @Test
    public void getUserInfosTestWithMock() {
        List<TestUserDto> allUsers = testUserServiceWithMock.getAllUsers();
//        List<TestUserInfoDto> userInfos = testUserServiceWithMock.getUserInfos(List.of(allUsers.get(1).getId(), dummyId));
        List<TestUserInfoDto> userInfos = testUserServiceWithMock.getUserInfos(List.of("anything", dummyId));

        assertThat(userInfos).hasSize(1);
        verify(testUserInfoServiceMock, times(2)).getUserInfo(anyString());
    }

    @Test
    public void getUserInfosTestWithSpy() {
        List<TestUserDto> allUsers = testUserServiceWithSpy.getAllUsers();
        String id1 = allUsers.get(1).getId();
        String id2 = dummyId;

        List<TestUserInfoDto> userInfos = testUserServiceWithSpy.getUserInfos(List.of(id1, id2));

        assertThat(userInfos).hasSize(1);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(testUserInfoServiceSpy, times(2)).getUserInfo(argumentCaptor.capture());
//        verify(testUserInfoServiceSpy, times(2)).getUserInfo(anyString());

        List<String> capturedIds = argumentCaptor.getAllValues();
        assertThat(capturedIds).containsExactlyInAnyOrder(id1, id2);
    }

    @Test
    public void getUserInfosTestVerifications() {
        String id = "anything";
        List<TestUserInfoDto> userInfos = testUserServiceWithMock.getUserInfos(Collections.singletonList(id));

        assertThat(userInfos).hasSize(1);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        verify(testUserInfoServiceMock).getUserInfo(argumentCaptor.capture());
//        verify(testUserInfoServiceMock).getUserInfo(anyString());

        String lastActualValue = argumentCaptor.getValue();
        assertThat(lastActualValue).isEqualTo(id);
    }

    @Test
    public void getUserInfosTestVerifications_ActualValue() {
        String id = "anything";
        List<TestUserInfoDto> userInfos = testUserServiceWithMock.getUserInfos(Collections.singletonList(id));

        assertThat(userInfos).hasSize(1);

        /*
            Could not mix actual values with "wild card" values ( like anyString() ) during the mockito verification
            in case if method has more than one parameter
            For instance, this will fail : verify(testUserInfoServiceMock).getUserInfo(id, anyString());
         */
        verify(testUserInfoServiceMock).getUserInfo(id);
    }

    @Test
    public void getUserInfosTestVerifications_NotCalled() {
        List<TestUserInfoDto> userInfos = testUserServiceWithMock.getUserInfos(new ArrayList<>());
        verify(testUserInfoServiceMock, never()).getUserInfo(anyString());
    }

}
