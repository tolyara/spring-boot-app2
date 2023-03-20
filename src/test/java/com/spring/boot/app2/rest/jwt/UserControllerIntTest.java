package com.spring.boot.app2.rest.jwt;

import com.springboot.app2.App2Application;
import com.springboot.app2.dao.jwt.UserRepository;
import com.springboot.app2.rest.jwt.UserController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = App2Application.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Transactional
public class UserControllerIntTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * TEST CASES
     *
     *     public static final String AUTH_LOGIN = "/auth/login";
     *     - permit all
     *     - correct password
     *     - incorrect password     *
     *
     *     public static final String USERS_BY_ID = "/users/{id}";
     *     - authenticated +/-
     *     - user found
     *     - user not found
     *
     *     public static final String ADMIN_USERS_BY_ID = "/admin/users/{id}";
     *     - authenticated, has admin permission +/-
     *
     */

    @Test
    public void authTest() throws Exception {

//        MvcResult mvcResult = mockMvc.perform(post(UserController.AUTH_LOGIN))
////                        .header(keyAuthorization, token))
//                .andExpect(status().isOk())
//                .andReturn();

    }

}
