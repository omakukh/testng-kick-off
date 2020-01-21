package com.lits.makukh.app;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


/**
 * Unit test for simple App.
 */
public class AppTest {


    @BeforeClass
    public void beforeClass() {
        System.out.println("*****Tests Class AppTest1 starter");

    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method");
    }

    @Test
    public void testApp() {
        assertTrue(true);
    }

    @Test(enabled = true,
            description = "tdbnfmnf")

    public void firstTest() {
    //    assertEquals(10, 4, "10 is not 4");

    }
}
