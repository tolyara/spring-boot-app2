package com.springboot.app2.dto.testing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestUserInfoDto {

    private String userId;
    private String address;
    private String phoneNumber;

}
