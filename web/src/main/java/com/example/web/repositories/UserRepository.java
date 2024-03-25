package com.example.web.repositories;

import java.util.List;
import java.util.Optional;

import com.example.web.domains.User;


public interface UserRepository {
    User add(User user);
    Optional<User> findById(String id);
    List<User> findAll();
}
