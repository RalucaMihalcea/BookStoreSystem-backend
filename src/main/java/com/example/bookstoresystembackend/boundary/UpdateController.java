package com.example.bookstoresystembackend.boundary;

import com.example.bookstoresystembackend.entity.User;
import com.example.bookstoresystembackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/update")
public class UpdateController {

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


    @PostMapping(path = "/update")
    public @ResponseBody
    String updateUser(@RequestBody User user) {

        User oldUser= userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setAddress(user.getAddress());
        oldUser.setContactNo(user.getContactNo());
        oldUser.setEmail(user.getEmail());
        userRepository.save(oldUser);
        return "Updated user";

    }



//    @PostMapping(path = "/updatee")
//    public @ResponseBody
//    String updateUser2(@RequestParam(name = "user_name") String username, @RequestParam String password, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String gender, @RequestParam int height, @RequestParam int weight, @RequestParam int age, @RequestParam String email, @RequestParam String contactNo) {
//
//        User oldUser= userRepository.findUserByUsernameAndPassword(username, password);
//        oldUser.setUsername(username);
//        oldUser.setPassword(password);
//        oldUser.setFirstName(user.getFirstName());
//        oldUser.setLastName(user.getLastName());
//        oldUser.setAddress(user.getAddress());
//        oldUser.setContactNo(user.getContactNo());
//        oldUser.setEmail(user.getEmail());
//        userRepository.save(oldUser);
//        return "Updated user";
//
//    }
}
