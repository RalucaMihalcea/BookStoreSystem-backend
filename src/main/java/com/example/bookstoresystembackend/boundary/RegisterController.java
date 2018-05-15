package com.example.bookstoresystembackend.boundary;


import com.example.bookstoresystembackend.entity.User;
import com.example.bookstoresystembackend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/register")
public class RegisterController {

    public static final Logger LOG = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewUser(@RequestBody User user) {

        LOG.debug("Before register a new user");
        LOG.info("Before register a new user");
        userRepository.save(user);
        LOG.debug("After register a new user");
        LOG.info("After register a new user");
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        LOG.info("Displays all the users from the database");
        return userRepository.findAll();
    }
}
