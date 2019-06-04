package com.alex.springv2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/admin")
@Controller
public class AdminController {


    @RequestMapping(value = "/admin")
    public String adminHome() {

        return "admin";
    }
}
