package com.springboot.app2.rest.test;

import com.springboot.app2.rest.test.TestController;
import com.springboot.app2.service.test.prototype.TestComponent1;
import com.springboot.app2.service.test.prototype.TestComponent2;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/*
    https://reflectoring.io/spring-boot-web-controller-test/#verifying-controller-responsibilities-with-webmvctest
    As of Spring Boot 2.1, we no longer need to load the SpringExtension because it's included as a meta annotation in the Spring Boot test annotations like @DataJpaTest, @WebMvcTest, and @SpringBootTest.
 */
//@ExtendWith(SpringExtension.class)

@WebMvcTest(TestController.class)
public class TestControllerIntTest {

    @Autowired
    private MockMvc mvc;

    @MockBean   // We can use @MockBean to add mock objects to the Spring application context. The mock will replace any existing bean of the same type in the application context.
    private TestComponent1 testComponent1;

    @MockBean
    private TestComponent2 testComponent2;

    @Test
    public void test() throws Exception {
        RequestBuilder request = get("/test");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("", result.getResponse().getContentAsString());
    }

}
