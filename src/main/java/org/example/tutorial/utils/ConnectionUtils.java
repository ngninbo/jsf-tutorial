package org.example.tutorial.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    public Connection getConnection() {
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/testdb";
        String user = "user1";
        String password = "user1";

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection completed.");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }
}
