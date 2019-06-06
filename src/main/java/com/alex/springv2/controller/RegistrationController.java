package com.alex.springv2.controller;


import com.alex.springv2.domain.entity.User;
import com.alex.springv2.service.RegistrationService;
import com.alex.springv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userService.findByUsername(user.getUsername());

        if(userFromDb != null) {
            model.put("message", "User exist!");
            return "registration";
        }

        registrationService.addNewUser(user);
        userService.save(user);

        return "redirect:/login";
    }
}
/*
<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />*/
