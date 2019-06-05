package com.alex.springv2.service.Impl;

import com.alex.springv2.domain.Answer;

import java.util.Map;
import java.util.TreeMap;

public class AutoTestPasser {

    public static Map<Integer, Answer> getPassedTest(int questionNumber) {
        Map<Integer, Answer> tempPassedTest = new TreeMap<>();
        for(int i = 1; i <= questionNumber; i++) {
            tempPassedTest.put(i, Answer.getRandomAnswer());
        }
        return tempPassedTest;
    }
}
