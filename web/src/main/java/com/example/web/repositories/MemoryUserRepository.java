package com.example.web.repositories;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.web.domains.User;

// @Repository
public class MemoryUserRepository implements UserRepository {
    private static Map<Long, User> users = new HashMap<>();
    private static long index = 0L;

    @Override
    public User add(User user) {
        user.setIndex(++index);
        users.put(user.getIndex(), user);
        return user;
    }

    // id 중복 확인
    @Override
    public Optional<User> findById(String id) {
        return users.values().stream()
                .filter(user -> user.getId().equals(id))
                .findAny();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public void clearUser() {
        users.clear();
    }

  
}
