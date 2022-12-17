package org.example.tutorial.backing;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class HelloWorldTest {

    private HelloWorld cut;

    @Before
    public void setUp() {
        cut = new HelloWorld();
        cut.setMessageBean(new Message());
    }

    @Test
    @Ignore
    public void testGetMessage() {
        assertEquals("Hello World!", cut.getMessage());
    }
}