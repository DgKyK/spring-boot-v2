package com.alex.springv2.Controller;

import com.alex.springv2.domain.Entity.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/admin")
@Controller
public class AdminController {

    @RequestMapping(value = "/admin")
    public String adminHome() {
        return "admin";
    }
}
