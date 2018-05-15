package com.example.bookstoresystembackend.boundary;

import com.example.bookstoresystembackend.entity.User;
import com.example.bookstoresystembackend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/update")
public class UpdateController {

    public static final Logger LOG = LoggerFactory.getLogger(UpdateController.class);

    @Autowired
    private UserRepository userRepository;
//
//    @PostMapping(path = "/update")
//    public @ResponseBody
//    String updateUser(@RequestBody User user) {
//
//        userRepository.save(user);
//        return "Updated user";
//
//    }


    @PostMapping(path = "/update2")
    public @ResponseBody
    String updateUser(@RequestBody User user) {

        User oldUser = userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        oldUser.setUsername(user.getUsername());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setContactNo(user.getContactNo());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        LOG.info("Before user update");
        userRepository.save(oldUser);
        LOG.info("After user update");
        return "Updated user";

    }


    @PostMapping(path = "/updatee")
    public @ResponseBody
        //@RequestParam(name = "user_name") String username
    String updateUser2(@RequestParam String username, @RequestParam String newUsername, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String contactNo) {

        User oldUser = userRepository.findUserByUsername(username);
        oldUser.setUsername(newUsername);
        oldUser.setFirstName(firstName);
        oldUser.setLastName(lastName);
        oldUser.setContactNo(contactNo);
        oldUser.setEmail(email);
        LOG.info("Before user update");
        userRepository.save(oldUser);
        LOG.info("After user update");
        return "Updated user";

    }
}
