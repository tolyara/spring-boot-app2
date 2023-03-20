package com.spring.boot.app2.rest.test;

import com.springboot.app2.rest.test.TestController;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TestController.class)
public class TestControllerIntTest {

//    @Autowired
    @Inject
    private MockMvc mvc;

    @Test
    void test() throws Exception {
        RequestBuilder request = get("/test");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("", result.getResponse().getContentAsString());
    }

}
