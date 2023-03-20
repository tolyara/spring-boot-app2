package com.springboot.app2.fortest;

import com.springboot.app2.util.fortest.StaticUtils;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

/**
 * https://www.baeldung.com/mockito-mock-static-methods
 * https://www.baeldung.com/introduction-to-assertj
 *
 */

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

    @Test
    public void givenStaticMethodWithArgs_whenMocked_thenReturnsMockSuccessfully() {
        Assertions.assertThat(StaticUtils.range(2, 6)).containsExactly(2, 3, 4, 5);

        try (MockedStatic<StaticUtils> utilities = Mockito.mockStatic(StaticUtils.class)) {
            utilities.when(() -> StaticUtils.range(2, 6))
                    .thenReturn(Arrays.asList(10, 11, 12));
            Assertions.assertThat(StaticUtils.range(2, 6)).containsExactly(10, 11, 12);
        }
        Assertions.assertThat(StaticUtils.range(2, 6)).containsExactly(2, 3, 4, 5);
    }

}
