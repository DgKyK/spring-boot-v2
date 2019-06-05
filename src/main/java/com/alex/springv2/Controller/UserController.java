package com.alex.springv2.Controller;

import com.alex.springv2.domain.Answer;
import com.alex.springv2.domain.Entity.Question;
import com.alex.springv2.domain.Entity.Test;
import com.alex.springv2.service.Impl.AutoTestPasser;
import com.alex.springv2.service.Impl.TestChecker;
import com.alex.springv2.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.put("tests", tests);
        return "user";
    }

    @RequestMapping("/test")
    public String passTest(@RequestParam String test, Map<String, Boolean> resultTest) {
        String[] splited = test.split("\\s\\|\\s");
        Long chosenTestId = Long.parseLong(splited[0]);
        List<Question> questList = testService.findAllByTestId(chosenTestId);
        Map<Integer, Answer> passedTest = AutoTestPasser.getPassedTest(questList.size());
        resultTest = TestChecker.getTestReview(questList,passedTest);
        System.out.println(resultTest);
        return "test";
    }
}
