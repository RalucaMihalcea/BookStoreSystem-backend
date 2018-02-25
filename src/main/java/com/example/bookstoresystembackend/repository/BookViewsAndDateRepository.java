package com.example.bookstoresystembackend.repository;

import com.example.bookstoresystembackend.entity.BookViews;
import com.example.bookstoresystembackend.entity.BookViewsAndDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Calendar;
import java.util.List;

public interface BookViewsAndDateRepository extends JpaRepository<BookViewsAndDate, Long> {

    List<BookViewsAndDate> findBooksViewsAndDateByIdBookAndDate(Long id, Calendar date);
    List<BookViewsAndDate> findBooksViewsAndDateByUsername(String username);
    List<BookViewsAndDate> findBooksViewsAndDateByIdAndUsername(Long id,String username);
    BookViewsAndDate findBookViewsAndDateByIdBookAndDate(Long idBook, Calendar date);

}
