package com.alex.springv2.Controller;

import com.alex.springv2.domain.Entity.Test;
import com.alex.springv2.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/user")
    public String userHome(Map<String, Object> model) {
        List<Test> tests = testService.getAll();
        System.out.println(tests);
        model.put("tests", tests);
        return "user";
    }
}
