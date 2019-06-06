package com.alex.springv2.service.impl;

import com.alex.springv2.domain.Answer;
import com.alex.springv2.domain.entity.Question;

import java.util.*;

public class TestChecker {

    public static Map<String, Boolean> getTestReview(List<Question> questions, Map<Integer, Answer> passedTest) {
        Map<String, Boolean> checkedTest = new LinkedHashMap<>();
        for(Integer currentQuest : passedTest.keySet()) {
            Answer rightAnswer = questions.get(currentQuest - 1).getAnswer();
            Answer givenAnswer = passedTest.get(currentQuest);
            if(rightAnswer.equals(givenAnswer)) {
                checkedTest.put(currentQuest + ". " + givenAnswer,true);
            } else {
                checkedTest.put(currentQuest + ". " + givenAnswer,false);
            }
        }
        return checkedTest;
    }
}
