package com.example.bookstoresystembackend.boundary;

import com.example.bookstoresystembackend.entity.Review;
import com.example.bookstoresystembackend.repository.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/review")
public class ReviewController {

    public static final Logger LOG = LoggerFactory.getLogger(ReviewController.class);

    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping(path = "/addReview")
    public @ResponseBody
    String addNewReview(@RequestBody Review review) {

        LOG.info("Before review saving");
        reviewRepository.save(review);
        LOG.info("After review saving");
        return "Review Saved";
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
        LOG.info("Before review saving");
        reviewRepository.save(review);
        LOG.info("After review saving");
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
        LOG.info("Search review by idBook");
        return reviewRepository.findReviewsByIdBook(idBook);
    }
}
