package org.example.tutorial.repository;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.tutorial.model.Author;
import org.example.tutorial.utils.ConnectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Slf4j
public class AuthorRepository {

    private ConnectionUtils connectionUtils;

    @Autowired
    public AuthorRepository(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public List<Author> findAll() {

        logger.info("Fetch authors from database...");

        String stm = "Select * from authors";
        List<Author> records = new ArrayList<>();

        try (Connection connection = connectionUtils.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(stm);
            pst.execute();
            ResultSet rs = pst.getResultSet();

            while(rs.next()) {
                Author author = Author.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .build();

                records.add(author);
            }
            logger.info("Fetching authors from database completed.");
        } catch (SQLException e) {
            logger.error("Fetching authors from database failed!:", e);
        }
        return records;
    }
}
