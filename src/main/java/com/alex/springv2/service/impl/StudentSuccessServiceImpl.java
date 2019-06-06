package com.alex.springv2.service.impl;

import com.alex.springv2.domain.entity.StudentSuccess;
import com.alex.springv2.domain.entity.Test;
import com.alex.springv2.domain.entity.User;
import com.alex.springv2.domain.TestStatus;
import com.alex.springv2.repositories.StudentSuccessRepository;
import com.alex.springv2.repositories.TestRepository;
import com.alex.springv2.service.StudentSuccessService;
import com.alex.springv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class StudentSuccessServiceImpl implements StudentSuccessService {


    @Autowired
    TestRepository testRepository;

    @Autowired
    StudentSuccessRepository studentSuccessRepository;

    @Autowired
    UserService userService;

    @Override
    public void saveCurrentResult(Map<String, Boolean> resultTest, String testInfo, String userName) {
        String[] splitted = testInfo.split("\\s\\|\\s");
        Test testFromBd = testRepository.getOne(Long.parseLong(splitted[0]));
        int writeAnswers = 0;
        int wrongAnswers = 0;
        for(String current : resultTest.keySet()) {
            if(resultTest.get(current)) {
                writeAnswers++;
            } else wrongAnswers++;
        }
        User currentUser = userService.findByUsername(userName);
        StudentSuccess currentResult = StudentSuccess.builder()
                .user(currentUser)
                .testName(testFromBd.getName())
                .testTheme(testFromBd.getTheme())
                .questNumber(testFromBd.getQuestNumber())
                .writeAnswer(writeAnswers)
                .wrongAnswer(wrongAnswers)
                .status((writeAnswers < testFromBd.getNeedAnswerNumb()) ? TestStatus.Failed : TestStatus.Passed).build();

        studentSuccessRepository.save(currentResult);
    }

    @Override
    public List<StudentSuccess> findAllByUserName(String userName) {
        User currentUser = userService.findByUsername(userName);
        return studentSuccessRepository.findAllByUserId(currentUser.getId());
    }
}
