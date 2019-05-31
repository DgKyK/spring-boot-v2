package com.alex.springv2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminHome() {
        return "admin";
    }

    @RequestMapping(value = "/user")
    public String userHome() {
        return "user";
    }

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = {"/", "/home"})
    public String startPage() {
        return "home";
    }

}
