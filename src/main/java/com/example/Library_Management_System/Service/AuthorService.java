package com.example.Library_Management_System.Service;

import com.example.Library_Management_System.Models.Author;
import com.example.Library_Management_System.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(Author author) {
        Author response=authorRepository.save(author);
        return "author added successfully";
    }
}
