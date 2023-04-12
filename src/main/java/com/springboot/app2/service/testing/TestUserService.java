package com.springboot.app2.service.testing;

import com.springboot.app2.dto.testing.TestUserDto;
import com.springboot.app2.enums.testing.TestUserType;
import com.springboot.app2.util.RandomUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestUserService {

    private static List<TestUserDto> USERS = List.of(
            new TestUserDto(String.valueOf(RandomUtil.generateRandomLongValue()), "James Bond", "007", 21, TestUserType.ADMIN),
            new TestUserDto(String.valueOf(RandomUtil.generateRandomLongValue()), "Frank Castle", "punisher", 40, TestUserType.MODERATOR),
            new TestUserDto(String.valueOf(RandomUtil.generateRandomLongValue()), "T Pain", "MrT", 40, TestUserType.USER)
    );

    public String hello() {
        return "Hello";
    }

    public List<String> getAllUserNames() {
        return USERS.stream().map(TestUserDto::getName).collect(Collectors.toList());
    }

    public List<TestUserDto> getAllAdminOrModeratorUsers() {
//        return USERS.stream().filter(u -> !TestUserType.USER.equals(u.getTestUserType())).collect(Collectors.toList());
        return USERS.stream().filter(u -> TestUserType.ADMIN.equals(u.getTestUserType())
                || TestUserType.MODERATOR.equals(u.getTestUserType())).collect(Collectors.toList());
    }

    public List<TestUserDto> getAllUsers() {
        return USERS;
    }

}
