package com.alex.springv2.controller;


import com.alex.springv2.domain.entity.User;
import com.alex.springv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {
    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        if(!userService.addUser(user)) {
            model.put("message", "User exist!");
            return "registration";
        }

        return "redirect:/login";
    }
}
/*
<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />*/
