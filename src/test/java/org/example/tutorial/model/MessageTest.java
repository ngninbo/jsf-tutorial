package org.example.tutorial.model;

import org.example.tutorial.backing.Message;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessageTest {

    private Message cut;

    @Before
    public void setUp() {
        cut = new Message();
    }

    @Test
    @Ignore
    public void testGetMessage() {
        assertEquals("Hello World!", cut.getMessage());
    }
}