package com.springboot.app2.service.testing;

import com.springboot.app2.dto.testing.TestUserDto;
import com.springboot.app2.dto.testing.TestUserInfoDto;
import com.springboot.app2.enums.testing.TestUserType;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TestUserService {

    private final TestUserInfoService testUserInfoService;

    public TestUserService(TestUserInfoService testUserInfoService) {
        this.testUserInfoService = testUserInfoService;
    }

    public String hello() {
        return "Hello";
    }

    public List<String> getAllUserNames() {
        return TestUserProvider.getUsersList().stream().map(TestUserDto::getName).collect(Collectors.toList());
    }

    public List<TestUserDto> getAllAdminOrModeratorUsers() {
//        return USERS.stream().filter(u -> !TestUserType.USER.equals(u.getTestUserType())).collect(Collectors.toList());
        return TestUserProvider.getUsersList().stream().filter(u -> TestUserType.ADMIN.equals(u.getTestUserType())
                || TestUserType.MODERATOR.equals(u.getTestUserType())).collect(Collectors.toList());
    }

    public List<TestUserDto> getAllUsers() {
        return TestUserProvider.getUsersList();
    }

    public List<TestUserInfoDto> getUserInfos(List<String> userIds) {
        if (CollectionUtils.isEmpty(userIds)) return Collections.emptyList();
        return userIds.stream().map(testUserInfoService::getUserInfo).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public TestUserDto getUserByName(String name) {
        return TestUserProvider.getUsersList().stream().filter(u -> u.getName().equals(name)).findFirst().orElse(null);
    }

}
