package org.example.tutorial.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessageTest {

    private Message cut;

    @Before
    public void setUp() {
        cut = new Message();
    }

    @Test
    public void testGetMessage() {
        assertEquals("Hello World!", cut.getMessage());
    }
}