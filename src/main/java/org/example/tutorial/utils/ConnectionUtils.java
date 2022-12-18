package org.example.tutorial.utils;

import lombok.extern.slf4j.Slf4j;

import javax.faces.bean.ApplicationScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@ApplicationScoped
@Slf4j
public class ConnectionUtils {

    public Connection getConnection() {

        logger.info("Connection to database started...");
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/testdb";
        String user = "user1";
        String password = "user1";

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
            logger.info("Connection completed.");
        } catch (SQLException | ClassNotFoundException ex) {
            logger.error("An exception occur while getting connection: {}", ex.getMessage());
        }
        return con;
    }
}
