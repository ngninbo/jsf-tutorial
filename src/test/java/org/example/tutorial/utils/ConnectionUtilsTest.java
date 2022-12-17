package org.example.tutorial.utils;

import junit.framework.TestCase;

public class ConnectionUtilsTest extends TestCase {

    public void testConnection() {
        ConnectionUtils cut = new ConnectionUtils();
        assertNotNull(cut.getConnection());
    }
}