package com.alex.springv2.Controller;

import com.alex.springv2.domain.Answer;
import com.alex.springv2.domain.Entity.Question;
import com.alex.springv2.domain.Entity.StudentSuccess;
import com.alex.springv2.domain.Entity.Test;
import com.alex.springv2.service.Impl.AutoTestPasser;
import com.alex.springv2.service.Impl.TestChecker;
import com.alex.springv2.service.StudentSuccessService;
import com.alex.springv2.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    TestService testService;

    @Autowired
    StudentSuccessService studentSuccessService;

    @RequestMapping(value = "/user")
    public String userHome(Map<String, Object> model) {
        List<Test> tests = testService.getAll();
        model.put("tests", tests);
        return "user";
    }

    @RequestMapping("/test")
    public String passTest(@RequestParam String chosenTest, Map<String, Boolean> resultTest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        List<Question> questList = testService.findAllByTestId(chosenTest);
        Map<Integer, Answer> passedTest = AutoTestPasser.getPassedTest(questList.size());
        resultTest = TestChecker.getTestReview(questList,passedTest);
        studentSuccessService.saveCurrentResult(resultTest,chosenTest,userDetails.getUsername());
        System.out.println(resultTest);
        return "test";
    }
}
