package com.alex.springv2.controller;

import com.alex.springv2.domain.Role;
import com.alex.springv2.domain.entity.GeneralStatistic;
import com.alex.springv2.domain.entity.User;
import com.alex.springv2.service.UserService;
import com.alex.springv2.service.impl.GeneralStatisticMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/admin")
@Controller
public class AdminController {

    @Autowired
    GeneralStatisticMapper mapper;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/admin")
    public String adminHome(Model model) {

        model.addAttribute("users", userService.findAll());

        return "admin";
    }

    @RequestMapping(value = "/statistic")
    public String generalStatistic(Model model,
                                   @PageableDefault(direction = Sort.Direction.DESC) Pageable pageable) {
        List<GeneralStatistic> statistic = mapper.getGeneralStatistic(pageable);
        model.addAttribute("statistic", statistic);
        return "statistic";
    }

    @GetMapping("/admin/{user}")
    public String editUser(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());

        return "editUser";
    }

    @PostMapping
    public String userSave(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("role") String role,
            @RequestParam("userId") User user) {
        user.setUsername(username);
        user.setEmail(email);
        user.setRole(Role.valueOf(role));

        userService.save(user);
        return "/admin/admin";
    }

}
