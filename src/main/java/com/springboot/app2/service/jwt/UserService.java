package com.springboot.app2.service.jwt;

import com.springboot.app2.entity.jwt.User;

import java.util.List;

public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);

}
