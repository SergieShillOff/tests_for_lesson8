package com.example.rumpilstilstkin.lesson4;

import com.example.rumpilstilstkin.lesson4.presenters.home.RepsPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class SuperTest {

    private MegaClassForTest testObject;

    @Before
    public void setUp() {
        testObject = new MegaClassForTest();
    }

    @Test
    public void testNumberFunWhenOContains(){
        assertEquals(3, testObject.someWithNumber("gfhogjhgj"));
    }

    @Test
    public void testNumberFunWhenONotContains(){
        assertEquals(-1, testObject.someWithNumber("gfhgjhgj"));
    }

    @Test
    public void testStringWhenCountZero(){
        String str = testObject.someWithString(0);
        assertTrue(str.isEmpty());
    }

    @Test
    public void testStringWhenCountMoreThenZero(){
        String str = testObject.someWithString(3);
        assertEquals("ooo", str);
    }

    @After
    public void after(){
        testObject = null;
    }
}
