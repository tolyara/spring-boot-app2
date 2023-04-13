package com.springboot.app2.service.testing;

import com.springboot.app2.dto.testing.TestUserDto;
import com.springboot.app2.dto.testing.TestUserInfoDto;
import com.springboot.app2.enums.testing.TestUserType;
import com.springboot.app2.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public final class TestUserProvider {

    private TestUserProvider() {}

    private static final List<TestUserDto> USERS = List.of(
            new TestUserDto(String.valueOf(RandomUtil.generateRandomLongValue()), "James Bond", "007", 21, TestUserType.ADMIN),
            new TestUserDto(String.valueOf(RandomUtil.generateRandomLongValue()), "Frank Castle", "punisher", 40, TestUserType.MODERATOR),
            new TestUserDto(String.valueOf(RandomUtil.generateRandomLongValue()), "T Pain", "MrT", 46, TestUserType.USER)
    );

    public List<TestUserDto> getUsersList() {
        return USERS;
    }

    public TestUserDto getUser(String userId) {
        if (userId == null) return null;
        return USERS.stream().filter(u -> userId.equals(u.getId())).findFirst().orElse(null);
    }

    public static List<TestUserInfoDto> getUserInfoList() {
        final List<TestUserInfoDto> result = new ArrayList<>(3);

        int i = 1;
        for (TestUserDto user : USERS) {
            result.add(new TestUserInfoDto(user.getId(), "Address" + i, "phone" + i));
            i++;
        }
        return result;
    }

}
