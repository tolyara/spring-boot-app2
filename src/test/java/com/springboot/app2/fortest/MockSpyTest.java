package com.springboot.app2.fortest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MockSpyTest {

    @Mock
    private List<String> mockList;

    @Spy
    private List<String> spyList;

    @Test
    public void testMockList() {
        // by default, calling the methods of mock object will do nothing
        mockList.add("test");
        Assert.assertNull(mockList.get(0));
        Assert.assertNull(mockList.iterator());
    }

    @Test
    public void testSpyList() {
        // spy object will call the real method when not stub
        spyList = new ArrayList<>();
        spyList.add("test");
        Assert.assertEquals("test", spyList.get(0));
    }

}
