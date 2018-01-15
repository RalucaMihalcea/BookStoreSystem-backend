package com.example.bookstoresystembackend.boundary;

import com.example.bookstoresystembackend.entity.Book;
import com.example.bookstoresystembackend.entity.FavoriteBook;
import com.example.bookstoresystembackend.entity.User;
import com.example.bookstoresystembackend.repository.FavoriteBookRepository;
import com.example.bookstoresystembackend.repository.BookRepository;
import com.example.bookstoresystembackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/favoriteBook")
public class FavoriteBookController {

    @Autowired
    private FavoriteBookRepository favoriteBookRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;


    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewFavoriteBook(@RequestBody FavoriteBook favoriteBook) {

        favoriteBookRepository.save(favoriteBook);
        return "Favorite Book Saved";
    }

    @PostMapping(path = "/addFavoriteBookParameters")
    public @ResponseBody
    String addNewFavoriteBook2(@RequestParam String title, @RequestParam String author, @RequestParam String username) {

        Book book = bookRepository.findBookByTitleAndAuthor(title, author);
        User user = userRepository.findByUsername(username);

        FavoriteBook favoriteBook = new FavoriteBook();
        favoriteBook.setIdBook(book.getId());
        favoriteBook.setIdUser(user.getId());

        favoriteBookRepository.save(favoriteBook);
        return "Favorite Book Saved";
    }

    @PostMapping(path = "/deleteFavoriteBookParameters")
    public @ResponseBody
    String deleteNewFavoriteBook(@RequestParam Long idBook, @RequestParam String username) {

        User user = userRepository.findByUsername(username);

        FavoriteBook favoriteBook = favoriteBookRepository.findFavoriteBooksByIdBookAndIdUser(idBook, user.getId());

        favoriteBookRepository.delete(favoriteBook);
        return "Favorite Book Deleted";
    }

    @PostMapping(path = "/selectFavoriteBookForUser")
    public @ResponseBody
    List<FavoriteBook> selectFavoriteBooks(@RequestParam String username) {

        User user = userRepository.findByUsername(username);

        return favoriteBookRepository.findFavoriteBooksByIdUser(user.getId());
    }


}