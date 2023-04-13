package com.springboot.app2.service.testing;

import com.springboot.app2.dto.testing.TestUserDto;
import com.springboot.app2.dto.testing.TestUserInfoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestUserInfoService {

    public TestUserInfoDto getUserInfo(String userId) {
        final TestUserDto user = TestUserProvider.getUser(userId);
        if (user == null) return null;

        final List<TestUserInfoDto> userInfos = TestUserProvider.getUserInfoList();
        return userInfos.stream().filter(userInfo -> userInfo.getUserId().equals(userId)).findFirst().orElse(null);
    }

}
