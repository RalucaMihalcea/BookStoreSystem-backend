//package com.example.bookstoresystembackend.boundary;
//
//import com.example.bookstoresystembackend.entity.User;
//import com.example.bookstoresystembackend.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import org.springframework.web.bind.annotation.*;
//
//@Controller    // This means that this class is a Controller
//@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
//public class LoginController {
//
//    //private static final Logger LOG = LoggerFactory.getLogger(VacancyController.class);
//
//    @Autowired // This means to get the bean called userRepository
//    // Which is auto-generated by Spring, we will use it to handle the data
//    private UserRepository userRepository;
//
//    @GetMapping(path="/add") // Map ONLY GET Requests
//    public @ResponseBody
//    String addNewUser (@RequestParam String username, @RequestParam String password, @RequestParam String firstName
//            , @RequestParam String lastName) {
//        // @ResponseBody means the returned String is the response, not a view name
//        // @RequestParam means it is a parameter from the GET or POST request
//
//        User n = new User();
//        n.setFirstName(firstName);
//        n.setLastName(lastName);
//        n.setPassword(password);
//        n.setUsername(username);
//        userRepository.save(n);
//        return "Saved";
//    }
//
////    @Autowired
////    private LoginService loginService;
////
////    @PostMapping("/login")
////    public LoginService.UserInfo login(@RequestBody @Valid User user) {
////        LOG.info("User {} signed in", user.getUsername());
////        return loginService.getUser(user);
////    }
//
//    @GetMapping(path="/all")
//    public @ResponseBody Iterable<User> getAllUsers() {
//        // This returns a JSON or XML with the users
//        return userRepository.findAll();
//    }
//}
//