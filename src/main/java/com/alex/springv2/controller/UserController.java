package com.alex.springv2.controller;

import com.alex.springv2.domain.Answer;
import com.alex.springv2.domain.entity.Question;
import com.alex.springv2.domain.entity.StudentSuccess;
import com.alex.springv2.domain.entity.Test;
import com.alex.springv2.service.impl.AutoTestPasser;
import com.alex.springv2.service.impl.TestChecker;
import com.alex.springv2.service.StudentSuccessService;
import com.alex.springv2.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import java.util.List;
import java.util.Map;

@RequestMapping(value = "/user")
@Controller
public class UserController {

    private TestService testService;
    private StudentSuccessService studentSuccessService;

    @Autowired
    public UserController(TestService testService, StudentSuccessService studentSuccessService) {
        this.testService = testService;
        this.studentSuccessService = studentSuccessService;
    }

    @RequestMapping(value = "/user")
    public String userHome(Map<String, Object> model) {
        List<Test> tests = testService.getAll();
        model.put("tests", tests);
        return "user";
    }

    @RequestMapping("/test")
    public String passTest(@RequestParam String chosenTest,  Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        List<Question> questList = testService.findAllByTestId(chosenTest);
        Map<Integer, Answer> passedTest = AutoTestPasser.getPassedTest(questList.size());
        Map<String, Boolean> resultTest = TestChecker.getTestReview(questList,passedTest);
        studentSuccessService.saveCurrentResult(resultTest,chosenTest,userDetails.getUsername());

        model.addAttribute("test", resultTest);
        System.out.println(resultTest);
        return "test";
    }

    @RequestMapping("/mystatistic")
    public String statistic(Model model,
                            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Page<StudentSuccess> page = studentSuccessService.findAllByUserName(userDetails.getUsername(), pageable);

        model.addAttribute("page", page);
        model.addAttribute("url", "/user/mystatistic");
        return "mystatistic";
    }
}
