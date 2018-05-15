package com.example.bookstoresystembackend.boundary;


import com.example.bookstoresystembackend.control.LoginService;
import com.example.bookstoresystembackend.entity.User;
import com.example.bookstoresystembackend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {

    public static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/login")
    public @ResponseBody
    User getUser(@RequestBody User user) {
        LOG.debug("Performing user login");
        LOG.info("Performing user login");
        return userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @PostMapping(path = "/login2")
    public @ResponseBody
    User getUser(@RequestParam(name = "user_name") String username, @RequestParam String password) {
        LOG.debug("Performing user login");
        LOG.info("Performing user login");
        return userRepository.findUserByUsernameAndPassword(username, password);
    }


}