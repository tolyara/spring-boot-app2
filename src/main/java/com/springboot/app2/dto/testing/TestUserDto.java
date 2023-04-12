package com.springboot.app2.dto.testing;

import com.springboot.app2.enums.testing.TestUserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestUserDto {

    private String id;
    private String name;
    private String userName;
    private int age;
    private TestUserType testUserType;

}
