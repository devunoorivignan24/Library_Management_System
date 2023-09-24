package com.example.Library_Management_System.Controller;

import com.example.Library_Management_System.Enum.Genre;
import com.example.Library_Management_System.Models.Book;
import com.example.Library_Management_System.ResponseDTO.BookResponse;
import com.example.Library_Management_System.Service.BookService;
import com.example.Library_Management_System.exception.AuthorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody Book book){
        try {
            String response = bookService.addBook(book);
            return response;
        }catch (AuthorNotFoundException e){
            return e.getMessage();
        }
    }
    //get list of books with particular genre and cost greater than given cost

    @GetMapping("/getBooks")
    public List<BookResponse> getBooksByGenreAndCostGreater(@RequestParam("q") String genre,@RequestParam("q1") double cost){
        return bookService.getBooksByGenreAndCostGreater(genre,cost);
    }
}
