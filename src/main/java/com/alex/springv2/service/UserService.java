package com.alex.springv2.service;

import com.alex.springv2.domain.User;

public interface UserService {
    User findByUsername(String name);
    void save(User user);
}
