package com.alex.springv2.service;


import com.alex.springv2.domain.Entity.User;

import java.util.List;

public interface UserService {
    User findByUsername(String name);
    void save(User user);
    List<User> findAll();
}
