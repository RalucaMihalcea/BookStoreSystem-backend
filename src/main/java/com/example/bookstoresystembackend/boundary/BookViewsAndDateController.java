package com.example.bookstoresystembackend.boundary;

import com.example.bookstoresystembackend.entity.Book;
import com.example.bookstoresystembackend.entity.BookViewsAndDate;
import com.example.bookstoresystembackend.repository.BookViewsAndDateRepository;
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

    @Autowired
    private BookViewsAndDateRepository bookViewsAndDateRepository;

    @PostMapping(path = "/addBookViewsAndDate")
    public @ResponseBody
    String addNewBookViewsAndDate(@RequestBody BookViewsAndDate bookViewsAndDate) {

        bookViewsAndDateRepository.save(bookViewsAndDate);
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

        bookViewsAndDateRepository.save(bookViewsAndDate);
        return "BookViews Saved";
    }

    @GetMapping(path = "/allBookViewsAndDate")
    public @ResponseBody
    List<BookViewsAndDate> getAllBooksViewsAndDate() {
        // This returns a JSON or XML with the users
        return bookViewsAndDateRepository.findAll();
    }

    @PostMapping(path = "/searchBooksViewsAndDateByIdAndUsername")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    List<BookViewsAndDate> getBooksViewsAndDateByIdAndUsername(@RequestParam Long id, @RequestParam String username) throws ParseException {

        return bookViewsAndDateRepository.findBooksViewsAndDateByIdAndUsername(id, username);
    }

    @PostMapping(path = "/searchBooksViewsAndDateByUsername")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    List<BookViewsAndDate> getBooksViewsAndDateByUsername(@RequestParam String username) throws ParseException {

        return bookViewsAndDateRepository.findBooksViewsAndDateByUsername(username);
    }

    @PostMapping(path = "/searchBooksViewsAndDateByIdBookAndDate")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    List<BookViewsAndDate> getBooksViewsAndDateByIdBookViewsAndDates(@RequestParam Long idBook, @RequestParam int month) throws ParseException {

//        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(df.parse(dateString));
        return bookViewsAndDateRepository.findBooksViewsAndDateByIdBookAndMonth(idBook, month);
    }

    @PostMapping(path = "/searchBooksViewsAndDateByIdBookAndDate2")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    BookViewsAndDate getBookViewsAndDateByIdBook(@RequestParam Long idBook, @RequestParam int month) throws ParseException {
//        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(df.parse(dateString));
        return bookViewsAndDateRepository.findBookViewsAndDateByIdBookAndMonth(idBook, month);
    }

    @PostMapping(path = "/updateBookViewsAndDate")
    public @ResponseBody
    String updateBookViewsAndDate(@RequestParam Long idBook, @RequestParam int views, @RequestParam int month) throws ParseException {

//        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(df.parse(dateString));

        BookViewsAndDate oldBookViewsAndDate = bookViewsAndDateRepository.findBookViewsAndDateByIdBookAndMonth(idBook, month);
        oldBookViewsAndDate.setIdBook(idBook);
        oldBookViewsAndDate.setViews(views);
        oldBookViewsAndDate.setMonth(month);

        bookViewsAndDateRepository.save(oldBookViewsAndDate);
        return "Updated  bookViewsAndDate";

    }

}
