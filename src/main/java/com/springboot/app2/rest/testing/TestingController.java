package com.springboot.app2.rest.testing;

import com.springboot.app2.dto.testing.TestUserDto;
import com.springboot.app2.service.testing.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing")
public class TestingController {

    @Autowired
    private TestUserService userService;

    @GetMapping("/{name}")
    public TestUserDto getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

}
