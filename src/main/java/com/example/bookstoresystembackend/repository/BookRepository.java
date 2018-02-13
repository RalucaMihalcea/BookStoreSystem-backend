package com.example.bookstoresystembackend.repository;

import com.example.bookstoresystembackend.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBookByCategory(String category);
    Book findBookByTitleAndAuthor(String title, String author);
    Book findBookById(Long id);

}
