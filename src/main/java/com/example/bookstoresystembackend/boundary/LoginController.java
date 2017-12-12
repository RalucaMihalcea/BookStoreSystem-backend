package com.example.bookstoresystembackend.boundary;

import com.example.bookstoresystembackend.control.LoginService;
import com.example.bookstoresystembackend.entity.User;
import com.example.bookstoresystembackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

  @Autowired
  private UserRepository userRepository;
  private LoginService loginService = new LoginService();


  @PostMapping(path = "/login")
  public @ResponseBody
  //User getUser(@RequestParam(name = "user_name") String username, @RequestParam String password) {
  User getUser(@RequestBody User user) {
    return userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
  }

  @PostMapping(path = "/login2")
  public @ResponseBody
    //User getUser(@RequestParam(name = "user_name") String username, @RequestParam String password) {
  User getUser2(@RequestParam(name = "user_name") String username, @RequestParam String password) {
    return userRepository.findUserByUsernameAndPassword(username, password);
  }


}