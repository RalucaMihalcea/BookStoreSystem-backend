package com.example.bookstoresystembackend.repository;

import com.example.bookstoresystembackend.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);

}
