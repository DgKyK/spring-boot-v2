package com.alex.springv2.Controller;


import com.alex.springv2.domain.Role;
import com.alex.springv2.domain.User;
import com.alex.springv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;


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

        user.setAccountStatus(true);
        user.setRoles(Collections.singleton(Role.USER));
        userService.save(user);
        return "redirect:/login";
    }



    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
/*
<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />*/
