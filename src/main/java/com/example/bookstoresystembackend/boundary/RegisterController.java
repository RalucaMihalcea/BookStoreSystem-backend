package com.example.bookstoresystembackend.boundary;

import com.example.bookstoresystembackend.entity.User;
import com.example.bookstoresystembackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/register")
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewUser(@RequestBody User user) {

        userRepository.save(user);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}
