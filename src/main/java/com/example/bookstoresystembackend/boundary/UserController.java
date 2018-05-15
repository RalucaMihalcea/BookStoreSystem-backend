package com.example.bookstoresystembackend.boundary;

import com.example.bookstoresystembackend.entity.Book;
import com.example.bookstoresystembackend.entity.User;
import com.example.bookstoresystembackend.repository.BookRepository;
import com.example.bookstoresystembackend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    public static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/addUser")
    public @ResponseBody
    String addNewUser(@RequestParam String username, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String password, @RequestParam String email, @RequestParam String contactNo, @RequestParam String address) {

        User user = new User();
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setEmail(email);
        user.setContactNo(contactNo);
        LOG.info("Before saving user");
        userRepository.save(user);
        LOG.info("After saving user");
        return "User Saved";
    }

    @PostMapping(path = "/getUserByUsername")
    public @ResponseBody
    User getUser(@RequestParam String username) {
        // This returns a JSON or XML with the users
        LOG.info("Displays the user searched by username");
        return userRepository.findUserByUsername(username);
    }

    @PostMapping(path = "/getUserByUsernameAndFirstNameAndLastName")
    public @ResponseBody
    User getUser2(@RequestParam String username, @RequestParam String firstName, @RequestParam String lastName) {
        // This returns a JSON or XML with the users
        LOG.info("Displays the user searched by userName, firstName and lastName");
        return userRepository.findUserByUsernameAndFirstNameAndLastName(username, firstName, lastName);
    }

    @PostMapping(path = "/addUsername")
    public @ResponseBody
    String addNewUserWithUsename(@RequestBody String username) {

        User user = new User();
        user.setUsername(username);
        userRepository.save(user);
        LOG.info("Register a new user with username");
        LOG.debug("Was saved a new user");
        return "Saved";

    }
}
