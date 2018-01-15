package com.example.bookstoresystembackend.repository;

import com.example.bookstoresystembackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsernameAndPassword(String username, String password);
    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);

}
