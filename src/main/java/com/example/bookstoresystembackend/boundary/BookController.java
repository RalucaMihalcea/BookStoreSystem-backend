package com.example.bookstoresystembackend.boundary;


import com.example.bookstoresystembackend.entity.Book;
import com.example.bookstoresystembackend.entity.User;
import com.example.bookstoresystembackend.repository.BookRepository;
import com.example.bookstoresystembackend.repository.UserRepository;
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
    String addNewBook2(@RequestParam String title, @RequestParam String author, @RequestParam double price, @RequestParam String namePicture, @RequestParam String category, @RequestParam int stars, @RequestParam String description) {

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(price);
        book.setNamePicture(namePicture);
        book.setCategory(category);
        book.setStars(stars);
        book.setDescription(description);
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
}
