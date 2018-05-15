package com.example.bookstoresystembackend.boundary;


import com.example.bookstoresystembackend.entity.BookViews;
import com.example.bookstoresystembackend.entity.User;
import com.example.bookstoresystembackend.repository.BookViewsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping(path = "/bookViews")
public class BookViewsController {

    public static final Logger LOG = LoggerFactory.getLogger(BookViewsController.class);

    @Autowired
    private BookViewsRepository bookViewsRepository;

    @PostMapping(path = "/addBookViews")
    public @ResponseBody
    String addNewBookViews(@RequestBody BookViews bookViews) {

        LOG.info("Before BookViews adding");
        bookViewsRepository.save(bookViews);
        LOG.info("After BookViews adding");
        return "BookViews Saved";
    }

    @PostMapping(path = "/addBookViewsParameters")
    public @ResponseBody
    String addNewBookViews2(@RequestParam Long idBook, @RequestParam int views, @RequestParam String username) {

        BookViews bookViews = new BookViews();
        bookViews.setIdBook(idBook);
        bookViews.setViews(views);
        bookViews.setUsername(username);

        LOG.info("Before BookViews adding");
        bookViewsRepository.save(bookViews);
        LOG.info("After BookViews adding");
        return "BookViews Saved";
    }

    //    @PostMapping(path = "/searchReviewByIdBookAndIdUser")
//    public @ResponseBody
//        //@RequestParam(name = "user_name") String username, @RequestParam String password
//    Review getReviewByIdBookAndIdUser(@RequestParam Long idBook, @RequestParam String username) {
//        return reviewRepository.findReviewByIdBookAndIdUser(idBook, username);
//    }
//
    @PostMapping(path = "/searchBooksViewsByUsername")
    public @ResponseBody
    //@RequestParam(name = "user_name") String username, @RequestParam String password
    List<BookViews> getBooksViewsByIdBook(@RequestParam String username) {
        LOG.info("Search BookViews by username");
        return bookViewsRepository.findBooksViewsByUsername(username);
    }

    @PostMapping(path = "/searchBookViews")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    BookViews getBookViewsByIdBook(@RequestParam Long idBook, @RequestParam String username) {
        LOG.info("Search BookViews by idBook and username");
        return bookViewsRepository.findBookViewsByIdBookAndUsername(idBook, username);
    }

    @PostMapping(path = "/updateBookViews")
    public @ResponseBody
    String updateBookViews(@RequestParam Long idBook, @RequestParam int views, @RequestParam String username) {

        BookViews oldBookViews = bookViewsRepository.findBookViewsByIdBookAndUsername(idBook, username);
        oldBookViews.setIdBook(idBook);
        oldBookViews.setUsername(username);
        oldBookViews.setViews(views);

        LOG.info("Before update BookViews entity");
        bookViewsRepository.save(oldBookViews);
        LOG.info("After update BookViews entity");
        return "Updated  bookViews";

    }
}
