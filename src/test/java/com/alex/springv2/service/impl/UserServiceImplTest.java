package com.alex.springv2.service.impl;

import com.alex.springv2.domain.entity.User;
import com.alex.springv2.repositories.UserRepository;
import com.alex.springv2.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;


    @Test
    public void addUser() {
        User user = new User();

        boolean isUserCreated = userService.addUser(user);
        Assert.assertTrue(isUserCreated);
    }

    @Test
    public void failAddUser() {
        User user = new User();
        user.setUsername("Alex");

        Mockito.doReturn(new User()).when(userRepository).findByUsername("Alex");

        boolean isUserCreated = userService.addUser(user);
        Assert.assertFalse(isUserCreated);
    }
}