package org.example.tutorial.backing;

import lombok.Data;
import org.example.tutorial.model.Author;
import org.example.tutorial.repository.AuthorRepository;
import org.example.tutorial.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Data
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }
}
