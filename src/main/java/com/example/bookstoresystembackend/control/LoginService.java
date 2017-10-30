package com.example.bookstoresystembackend.control;

import com.example.bookstoresystembackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginService {

    @Autowired
    private UserRepository userRepository;
}
