package org.example.tutorial.backing;

import org.example.tutorial.model.Message;
import org.junit.Before;
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
    public void testGetMessage() {
        assertEquals("Hello World!", cut.getMessage());
    }
}