package com.example.bookstoresystembackend.boundary;


import com.example.bookstoresystembackend.entity.Book;
import com.example.bookstoresystembackend.entity.BookViews;
import com.example.bookstoresystembackend.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    public static final Logger LOG = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookRepository bookRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewBook(@RequestBody Book book) {

        LOG.info("Before book saving");
        LOG.debug("Before book saving");
        bookRepository.save(book);
        LOG.info("After book saving");
        LOG.debug("After book saving");

        return "Book Saved";

    }

    @PostMapping(path = "/addParameters")
    public @ResponseBody
    String addNewBook2(@RequestParam String title, @RequestParam String author, @RequestParam double price, @RequestParam String namePicture, @RequestParam String category, @RequestParam int stars, @RequestParam String description, @RequestParam int notified, @RequestParam String pdfLink) {

        Book book = new Book();
        book.setTitle(title);

        book.setAuthor(author);
        book.setPrice(price);
        book.setNamePicture(namePicture);
        book.setCategory(category);
        book.setStars(stars);
        book.setDescription(description);
        book.setNotified(notified);
        book.setPdfLink(pdfLink);
        LOG.info("Before book saving");
        bookRepository.save(book);
        LOG.info("After book saving");
        return "Book Saved";
    }

    @GetMapping(path = "/allBooks")
    public @ResponseBody
    List<Book> getAllBooks() {

        // This returns a JSON or XML with the users
        LOG.info("Displays all the books from the database");
        return bookRepository.findAll();
    }

    @PostMapping(path = "/searchBookByCategory")
    public @ResponseBody
    List<Book> getBook(@RequestBody Book book) {

        LOG.debug("Performing book by category search");
        LOG.info("Performing book by category search");
        return bookRepository.findBookByCategory(book.getCategory());
    }

    @PostMapping(path = "/searchBookByCategory2")
    public @ResponseBody
    List<Book> getBook(@RequestParam String category) {

        LOG.info("Performing book by category search");
        return bookRepository.findBookByCategory(category);
    }

    @PostMapping(path = "/searchBookByID")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    Book getBook(@RequestParam Long id) {

        LOG.debug("Performing book by ID search");
        LOG.info("Performing book by ID search");
        return bookRepository.findBookById(id);//foodRepository.findFoodById(food.getId());//foodRepository.findFoodByFood_name(food.getFood_name()); //foodRepository.findFoodByFood_nameAndCarbohydratesAndProteinsAndFatsAndCategory(food.getFood_name(), food.getCarbohydrates(), food.getProteins(), food.getFats(), food.getCategory());
    }

//    @PostMapping(path = "/updateBookNotified")
//    public @ResponseBody
//    String updateBook(@RequestParam String title, @RequestParam String author, @RequestParam int notified) {
//
//        Book oldBook = bookRepository.findBookByTitleAndAuthor(title, author);
//        oldBook.setNotified(notified);
//
//        bookRepository.save(oldBook);
//        return "Updated  book (notified)";
//
//    }

    @PostMapping(path = "/updateBookDescription")
    public @ResponseBody
    String updateBookDescription(@RequestParam String title, @RequestParam String author, @RequestParam String description) {

        Book oldBook = bookRepository.findBookByTitleAndAuthor(title, author);
        oldBook.setDescription(description);

        LOG.info("Before update description field of the book entity");
        bookRepository.save(oldBook);
        LOG.info("After update description field of the book entity");
        return "Updated  book (description)";
    }

    @PostMapping(path = "/updateBookPdfLink")
    public @ResponseBody
    String updateBookPdfLink(@RequestParam String title, @RequestParam String author, @RequestParam String pdfLink) {

        Book oldBook = bookRepository.findBookByTitleAndAuthor(title, author);
        oldBook.setPdfLink(pdfLink);

        LOG.info("Before update pdfLink field of the book entity");
        bookRepository.save(oldBook);
        LOG.info("After update pdfLink field of the book entity");
        return "Updated  book (pdfLink)";
    }

    @PostMapping(path = "/updateBookAudioLink")
    public @ResponseBody
    String updateBookAudioLink(@RequestParam String title, @RequestParam String author, @RequestParam String audioLink) {

        Book oldBook = bookRepository.findBookByTitleAndAuthor(title, author);
        oldBook.setAudioLink(audioLink);

        LOG.info("Before update audioLink field of the book entity");
        bookRepository.save(oldBook);
        LOG.info("After update audioLink field of the book entity");
        return "Updated  book (audioLink)";

    }

    @PostMapping(path = "/updateBookImageLink")
    public @ResponseBody
    String updateBookImageLink(@RequestParam String title, @RequestParam String author, @RequestParam String imageLink) {

        Book oldBook = bookRepository.findBookByTitleAndAuthor(title, author);
        oldBook.setImageLink(imageLink);

        LOG.info("Before update imageLink field of the book entity");
        bookRepository.save(oldBook);
        LOG.info("After update imageLink field of the book entity");

        return "Updated  book (imageLink)";

    }
}
