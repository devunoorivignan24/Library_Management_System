package com.example.Library_Management_System.Repository;

import com.example.Library_Management_System.Enum.Genre;
import com.example.Library_Management_System.Models.Author;
import com.example.Library_Management_System.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query(value = "select * from book where genre=:genre and cost>:cost",nativeQuery = true)
    List<Book> getBooksByGenreAndCostGreater(String genre, double cost);
}
