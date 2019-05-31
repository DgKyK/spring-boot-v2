package com.alex.springv2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {


    @GetMapping(value = "/admin")
    public String adminHome() {
        return "admin";
    }

    @GetMapping(value = "/user")
    public String userHome() {
        return "user";
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping(value = {"/", "/home"})
    public String startPage() {
        return "home";
    }

}
