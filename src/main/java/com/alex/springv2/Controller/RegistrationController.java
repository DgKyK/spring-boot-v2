package com.alex.springv2.Controller;


import com.alex.springv2.domain.Role;
import com.alex.springv2.domain.User;
import com.alex.springv2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if(userFromDb != null) {
            model.put("message", "User exist!");
            return "registration";
        }

        user.setAccountStatus(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        return "redirect:/login";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }


    /*@GetMapping
    public String login() {
        return "login";
    }
    @PostMapping("/login")
    public String afterAuth() {
        return "hello";
    }*/
}
/*
<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />*/
