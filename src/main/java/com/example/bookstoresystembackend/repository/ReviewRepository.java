package com.example.bookstoresystembackend.repository;

import com.example.bookstoresystembackend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
   // Review findReviewByIdBookAndIdUser(Long idBook, String username);

    List<Review> findReviewsByIdBook(Long idBook);

}
