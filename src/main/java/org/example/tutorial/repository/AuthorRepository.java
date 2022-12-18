package org.example.tutorial.repository;

import lombok.Data;
import lombok.NoArgsConstructor;
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
public class AuthorRepository {

    private ConnectionUtils connectionUtils;

    @Autowired
    public AuthorRepository(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public List<Author> findAll() {

        String stm = "Select * from authors";
        List<Author> records = new ArrayList<>();

        try (Connection connection = connectionUtils.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(stm);
            pst.execute();
            ResultSet rs = pst.getResultSet();

            while(rs.next()) {
                Author author = new Author();
                author.setId(rs.getInt(1));
                author.setName(rs.getString(2));
                records.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }
}
