package com.example.bookstoresystembackend.repository;

import com.example.bookstoresystembackend.entity.FavoriteBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteBookRepository extends JpaRepository<FavoriteBook, Long> {
    // Review findReviewByIdBookAndIdUser(Long idBook, String username);

    List<FavoriteBook> findFavoriteBooksByIdUser(Long idUser);
    FavoriteBook findFavoriteBooksByIdBookAndIdUser(Long idBook, Long idUser);
    //FavoriteBook findFavoriteBooksBy

}

