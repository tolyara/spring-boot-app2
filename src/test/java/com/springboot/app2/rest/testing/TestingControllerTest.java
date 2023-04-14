package com.springboot.app2.rest.testing;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestingControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllUserNamesTest() throws Exception {
        MockHttpServletRequestBuilder builder = get("/testing/usernames");

        mvc.perform(builder).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(containsInAnyOrder("James Bond", "Frank Castle", "T Pain")));
    }

    @Test
    public void getUserByNameTest() throws Exception {
        MockHttpServletRequestBuilder builder = get("/testing/{name}", "James Bond");

        mvc.perform(builder).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(is("James Bond")))
                .andExpect(jsonPath("$.userName").value(is("007")));
    }

}
