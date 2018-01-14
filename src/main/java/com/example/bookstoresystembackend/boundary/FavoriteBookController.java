package com.example.bookstoresystembackend.boundary;

import com.example.bookstoresystembackend.entity.FavoriteBook;
import com.example.bookstoresystembackend.repository.FavoriteBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/favoriteBook")
public class FavoriteBookController {

    @Autowired
    private FavoriteBookRepository favoriteBookRepository;


    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewFavoriteBook(@RequestBody FavoriteBook favoriteBook) {

        favoriteBookRepository.save(favoriteBook);
        return "Favorite Book Saved";
    }

    @PostMapping(path = "/addFavoriteBookParameters")
    public @ResponseBody
    String addNewFavoriteBook2(@RequestParam Long idBook, @RequestParam String title, @RequestParam String author, @RequestParam String category, @RequestParam String namePicture, @RequestParam String username) {

        FavoriteBook favoriteBook = new FavoriteBook();
        favoriteBook.setIdBook(idBook);
        favoriteBook.setTitle(title);
        favoriteBook.setAuthor(author);
        favoriteBook.setCategory(category);
        favoriteBook.setNamePicture(namePicture);
        favoriteBook.setUsername(username);

        favoriteBookRepository.save(favoriteBook);
        return "FavoriteBook Saved";
    }

    //    @PostMapping(path = "/searchReviewByIdBookAndIdUser")
//    public @ResponseBody
//        //@RequestParam(name = "user_name") String username, @RequestParam String password
//    Review getReviewByIdBookAndIdUser(@RequestParam Long idBook, @RequestParam String username) {
//        return reviewRepository.findReviewByIdBookAndIdUser(idBook, username);
//    }
//
    @PostMapping(path = "/searchFavoriteBookByUsername")
    public @ResponseBody
    //@RequestParam(name = "user_name") String username, @RequestParam String password
    List<FavoriteBook> getFavoriteBookByUsername(@RequestParam String username) {
        return favoriteBookRepository.findFavoriteBooksByUsername(username);
    }
}