package com.example.rumpilstilstkin.lesson4;


import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


public class ExampleUnitTest {

    @Test
    public void addition_correct() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void addition_isNotCorrect() throws Exception {
        assertEquals("Numbers isn't equals!", 5, 2 + 2);
    }

    @Test(expected = NullPointerException.class)
    public void nullStringTest() {
        String str = "gfhgfh";
        assertTrue(str.isEmpty());
    }
}
