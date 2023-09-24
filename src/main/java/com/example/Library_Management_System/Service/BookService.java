package com.example.Library_Management_System.Service;

import com.example.Library_Management_System.Enum.Genre;
import com.example.Library_Management_System.Models.Author;
import com.example.Library_Management_System.Models.Book;
import com.example.Library_Management_System.Repository.AuthorRepository;
import com.example.Library_Management_System.Repository.BookRepository;
import com.example.Library_Management_System.ResponseDTO.BookResponse;
import com.example.Library_Management_System.exception.AuthorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;
    public String addBook(Book book) {
            Optional<Author> authorOptional= authorRepository.findById(book.getAuthor().getId());
            if(authorOptional.isEmpty()){
                throw new AuthorNotFoundException("Invalid author id");
            }
            Author author=authorOptional.get();
            book.setAuthor(author);
            author.getBooks().add(book);

            authorRepository.save(author);
            return "book saved successfully";
    }

    public List<BookResponse> getBooksByGenreAndCostGreater(String genre, double cost) {
        List<Book> books=bookRepository.getBooksByGenreAndCostGreater(genre,cost);

        List<BookResponse> response=new ArrayList<>();
        for(Book book:books){
            BookResponse book1=new BookResponse();
            book1.setCost(book.getCost());
            book1.setGenre(book.getGenre());
            book1.setTitle(book.getTitle());
            book1.setNoOfPages(book.getNoOfPages());
            book1.setAuthorName(book.getAuthor().getName());
            response.add(book1);
        }
        return response;

    }
}
