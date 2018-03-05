package com.example.bookstoresystembackend.repository;

import com.example.bookstoresystembackend.entity.BookViews;
import com.example.bookstoresystembackend.entity.BookViewsAndDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Calendar;
import java.util.List;

public interface BookViewsAndDateRepository extends JpaRepository<BookViewsAndDate, Long> {

    List<BookViewsAndDate> findBooksViewsAndDateByIdBookAndMonth(Long id, int month);
    List<BookViewsAndDate> findBooksViewsAndDateByUsername(String username);
    List<BookViewsAndDate> findBooksViewsAndDateByIdAndUsername(Long id,String username);
    BookViewsAndDate findBookViewsAndDateByIdBookAndMonth(Long idBook, int month);
    BookViewsAndDate findBookViewsAndDateByIdBookAndUsername(Long id,String username);
    BookViewsAndDate findBookViewsAndDateByIdBookAndUsernameAndMonth(Long idBook, String username, int month);

}
