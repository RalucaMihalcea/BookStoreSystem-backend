package com.example.bookstoresystembackend.boundary;

import com.example.bookstoresystembackend.entity.Review;
import com.example.bookstoresystembackend.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/review")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping(path = "/addReview")
    public @ResponseBody
    String addNewReview(@RequestBody Review review) {

        reviewRepository.save(review);
        return "Book Saved";
    }

    @PostMapping(path = "/addReviewParameters")
    public @ResponseBody
    String addNewReview2(@RequestParam Long idBook,
                         @RequestParam String username,
                         @RequestParam String textReview,
                         @RequestParam int starReview) {

        Review review = new Review();
        review.setIdBook(idBook);
        review.setUsername(username);
        review.setTextReview(textReview);
        review.setStarReview(starReview);
        reviewRepository.save(review);
        return "Review Saved";
    }

//    @PostMapping(path = "/searchReviewByIdBookAndIdUser")
//    public @ResponseBody
//        //@RequestParam(name = "user_name") String username, @RequestParam String password
//    Review getReviewByIdBookAndIdUser(@RequestParam Long idBook, @RequestParam String username) {
//        return reviewRepository.findReviewByIdBookAndIdUser(idBook, username);
//    }
//
    @PostMapping(path = "/searchReviewByIdBook")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    List<Review> getReviewByIdBook(@RequestParam Long idBook) {
        return reviewRepository.findReviewsByIdBook(idBook);
    }
}
