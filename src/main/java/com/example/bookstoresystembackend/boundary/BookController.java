package com.example.bookstoresystembackend.boundary;


import com.example.bookstoresystembackend.entity.Book;
import com.example.bookstoresystembackend.entity.BookViews;
import com.example.bookstoresystembackend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewBook(@RequestBody Book book) {

        bookRepository.save(book);
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
        bookRepository.save(book);
        return "Book Saved";
    }

    @GetMapping(path = "/allBooks")
    public @ResponseBody
    List<Book> getAllBooks() {
        // This returns a JSON or XML with the users
        return bookRepository.findAll();
    }

    @PostMapping(path = "/searchBookByCategory")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    List<Book> getBook(@RequestBody Book book) {
        return bookRepository.findBookByCategory(book.getCategory());
    }

    @PostMapping(path = "/searchBookByCategory2")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    List<Book> getBook(@RequestParam String category) {
        return bookRepository.findBookByCategory(category);//foodRepository.findFoodById(food.getId());//foodRepository.findFoodByFood_name(food.getFood_name()); //foodRepository.findFoodByFood_nameAndCarbohydratesAndProteinsAndFatsAndCategory(food.getFood_name(), food.getCarbohydrates(), food.getProteins(), food.getFats(), food.getCategory());
    }

    @PostMapping(path = "/searchBookByID")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username, @RequestParam String password
    Book getBook(@RequestParam Long id) {
        return bookRepository.findBookById(id);//foodRepository.findFoodById(food.getId());//foodRepository.findFoodByFood_name(food.getFood_name()); //foodRepository.findFoodByFood_nameAndCarbohydratesAndProteinsAndFatsAndCategory(food.getFood_name(), food.getCarbohydrates(), food.getProteins(), food.getFats(), food.getCategory());
    }

    @PostMapping(path = "/updateBookNotified")
    public @ResponseBody
    String updateBook(@RequestParam String title, @RequestParam String author, @RequestParam int notified) {

        Book oldBook = bookRepository.findBookByTitleAndAuthor(title, author);
        oldBook.setNotified(notified);

        bookRepository.save(oldBook);
        return "Updated  book (notified)";

    }
    @PostMapping(path = "/updateBookPdfLink")
    public @ResponseBody
    String updateBookPdfLink(@RequestParam String title, @RequestParam String author, @RequestParam String pdfLink) {

        Book oldBook = bookRepository.findBookByTitleAndAuthor(title, author);
        oldBook.setPdfLink(pdfLink);

        bookRepository.save(oldBook);
        return "Updated  book (pdfLink)";
    }

    @PostMapping(path = "/updateBookAudioLink")
    public @ResponseBody
    String updateBookAudioLink(@RequestParam String title, @RequestParam String author, @RequestParam String audioLink) {

        Book oldBook = bookRepository.findBookByTitleAndAuthor(title, author);
        oldBook.setAudioLink(audioLink);

        bookRepository.save(oldBook);
        return "Updated  book (audioLink)";

    }
}
