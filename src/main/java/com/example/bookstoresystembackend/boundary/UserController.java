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
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/addUser")
    public @ResponseBody
    String addNewUser(@RequestParam String username, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String password, @RequestParam  String email, @RequestParam  String contactNo, @RequestParam String address) {

        User user = new User();
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setEmail(email);
        user.setContactNo(contactNo);
        userRepository.save(user);
        return "User Saved";
    }
}
