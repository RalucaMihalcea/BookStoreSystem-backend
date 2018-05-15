package com.example.bookstoresystembackend.boundary;

import com.example.bookstoresystembackend.entity.Book;
import com.example.bookstoresystembackend.entity.BookViewsAndDate;
import com.example.bookstoresystembackend.repository.BookViewsAndDateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping(path = "/bookViewsAndDate")
public class BookViewsAndDateController {

    public static final Logger LOG = LoggerFactory.getLogger(BookViewsAndDateController.class);

    @Autowired
    private BookViewsAndDateRepository bookViewsAndDateRepository;

    @PostMapping(path = "/addBookViewsAndDate")
    public @ResponseBody
    String addNewBookViewsAndDate(@RequestBody BookViewsAndDate bookViewsAndDate) {

        LOG.debug("Before Add BookViewsAndDate");
        LOG.info("Before Add BookViewsAndDate");
        bookViewsAndDateRepository.save(bookViewsAndDate);
        LOG.debug("After Add BookViewsAndDate");
        LOG.info("After Add BookViewsAndDate");
        return "BookViews Saved";
    }

    @PostMapping(path = "/addBookViewsAndDateParameters")
    public @ResponseBody
    String addNewBookViewsAndDate2(@RequestParam Long idBook, @RequestParam int views, @RequestParam int month, @RequestParam String username) throws ParseException {

//        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(df.parse(dateString));

        BookViewsAndDate bookViewsAndDate = new BookViewsAndDate();
        bookViewsAndDate.setIdBook(idBook);
        bookViewsAndDate.setViews(views);
        bookViewsAndDate.setMonth(month);
        bookViewsAndDate.setUsername(username);

        LOG.debug("Before Create new BookViewsAndDate");
        LOG.info("Before Create new BookViewsAndDate");
        bookViewsAndDateRepository.save(bookViewsAndDate);
        LOG.debug("After Create new BookViewsAndDate");
        LOG.info("After Create new BookViewsAndDate");
        return "BookViewsAndDate Saved";
    }

    @GetMapping(path = "/allBookViewsAndDate")
    public @ResponseBody
    List<BookViewsAndDate> getAllBooksViewsAndDate() {
        // This returns a JSON or XML with the users
        LOG.debug("Display all BookViewsAndDate");
        LOG.info("Display all BookViewsAndDate");
        return bookViewsAndDateRepository.findAll();
    }

    @PostMapping(path = "/searchBooksViewsAndDateByIdAndUsername")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    BookViewsAndDate getBooksViewsAndDateByIdAndUsername(@RequestParam Long idBook, @RequestParam String username) throws ParseException {
        LOG.debug("Search BookViewsAndDate by ID and username");
        LOG.info("Search BookViewsAndDate by ID and username");
        return bookViewsAndDateRepository.findBookViewsAndDateByIdBookAndUsername(idBook, username);
    }

    @PostMapping(path = "/searchBooksViewsAndDateByUsername")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    List<BookViewsAndDate> getBooksViewsAndDateByUsername(@RequestParam String username) throws ParseException {
        LOG.debug("Search BooksViewsAndDate by username");
        LOG.info("Search BooksViewsAndDate by username");
        return bookViewsAndDateRepository.findBooksViewsAndDateByUsername(username);
    }

    @PostMapping(path = "/searchBooksViewsAndDateByIdBookAndDate")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    List<BookViewsAndDate> getBooksViewsAndDateByIdBookViewsAndDates(@RequestParam Long idBook, @RequestParam int month) throws ParseException {

//        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(df.parse(dateString));
        LOG.debug("Search BooksViewsAndDate by username and month");
        LOG.info("Search BooksViewsAndDate by username and month");
        return bookViewsAndDateRepository.findBooksViewsAndDateByIdBookAndMonth(idBook, month);
    }

    @PostMapping(path = "/searchBooksViewsAndDateByIdBookAndDate2")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    BookViewsAndDate getBookViewsAndDateByIdBook(@RequestParam Long idBook, @RequestParam int month) throws ParseException {
//        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(df.parse(dateString));
        LOG.debug("Search BooksViewsAndDate by idBook and month");
        LOG.info("Search BooksViewsAndDate by idBook and month");
        return bookViewsAndDateRepository.findBookViewsAndDateByIdBookAndMonth(idBook, month);
    }

    @PostMapping(path = "/updateBookViewsAndDate")
    public @ResponseBody
    String updateBookViewsAndDate(@RequestParam Long idBook, @RequestParam int views, @RequestParam String username, @RequestParam int month) throws ParseException {

//        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(df.parse(dateString));

        BookViewsAndDate oldBookViewsAndDate = bookViewsAndDateRepository.findBookViewsAndDateByIdBookAndUsernameAndMonth(idBook, username, month);
        oldBookViewsAndDate.setViews(views);

        LOG.info("Before BooksViewsAndDate updating");
        bookViewsAndDateRepository.save(oldBookViewsAndDate);
        LOG.info("After BooksViewsAndDate updating");
        return "Updated  bookViewsAndDate";

    }

}
