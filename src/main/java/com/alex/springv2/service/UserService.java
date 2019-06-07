package com.alex.springv2.service;


import com.alex.springv2.domain.entity.User;

import java.util.List;

public interface UserService {
    User findByUsername(String name);
    void save(User user);
    List<User> findAll();
    boolean addUser(User user);
}
