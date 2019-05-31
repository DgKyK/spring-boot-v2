package com.alex.springv2.service.Impl;

import com.alex.springv2.domain.User;
import com.alex.springv2.repositories.UserRepository;
import com.alex.springv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
