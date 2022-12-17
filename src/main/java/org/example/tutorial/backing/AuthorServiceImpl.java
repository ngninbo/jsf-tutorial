package org.example.tutorial.backing;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tutorial.model.Author;
import org.example.tutorial.repository.AuthorRepository;
import org.example.tutorial.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Data
@NoArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }
}
