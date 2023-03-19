package com.springboot.app2.dto.jwt;

import lombok.Data;

@Data
public class AuthenticationRequestDto {

    private String username;
    private String password;

}
