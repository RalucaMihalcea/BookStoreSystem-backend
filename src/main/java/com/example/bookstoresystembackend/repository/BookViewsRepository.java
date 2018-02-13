package com.example.bookstoresystembackend.repository;

import com.example.bookstoresystembackend.entity.BookViews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookViewsRepository extends JpaRepository<BookViews, Long> {
    List<BookViews> findBooksViewsByIdBookAndUsername(Long idBook, String username);
    BookViews findBookViewsByIdBookAndUsername(Long idBook, String username);



}
