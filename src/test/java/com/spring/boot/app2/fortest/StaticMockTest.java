package com.spring.boot.app2.fortest;

import com.springboot.app2.util.fortest.StaticUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class) // without @RunWith an exception will occur - runners.model.InvalidTestClassError: Invalid test class 'com.spring.boot.app2.fortest.StaticMockTest':
public class StaticMockTest {

    @Test
    public void givenStaticMethodWithNoArgs_whenMocked_thenReturnsMockSuccessfully() {
        Assert.assertEquals(StaticUtils.NAME, StaticUtils.name());

        try (MockedStatic<StaticUtils> utilities = Mockito.mockStatic(StaticUtils.class)) {
            utilities.when(StaticUtils::name).thenReturn("Tony");
            Assert.assertEquals("Tony", StaticUtils.name());
        }
        Assert.assertEquals(StaticUtils.NAME, StaticUtils.name());
    }

}
