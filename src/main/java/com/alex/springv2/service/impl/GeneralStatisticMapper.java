package com.alex.springv2.service.impl;

import com.alex.springv2.domain.Activity;
import com.alex.springv2.domain.TestStatus;
import com.alex.springv2.domain.entity.GeneralStatistic;
import com.alex.springv2.domain.entity.StudentSuccess;
import com.alex.springv2.domain.entity.User;
import com.alex.springv2.service.StudentSuccessService;
import com.alex.springv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeneralStatisticMapper {

    @Autowired
    StudentSuccessService studentSuccessService;

    @Autowired
    UserService userService;

    public List<GeneralStatistic> getGeneralStatistic(Pageable pageable) {
        List<GeneralStatistic> resultStatistic = new ArrayList<>();
        GeneralStatistic temp;
        List<User> allUsers = userService.findAll();
        for(User user : allUsers) {
            Page<StudentSuccess> userSuccess = studentSuccessService.findAllByUserName(user.getUsername(), pageable);
            int testsNumber = (int)userSuccess.stream().count();
            temp = GeneralStatistic.builder()
                    .tests(testsNumber)
                    .passed( (int)userSuccess.stream().filter( x -> x.getStatus().equals(TestStatus.Passed)).count() )
                    .failed( (int)userSuccess.stream().filter( x -> x.getStatus().equals(TestStatus.Failed)).count() )
                    .userName(user.getUsername())
                    .activity(testsNumber > 4 ? Activity.HIGH : Activity.LOW).build();
            resultStatistic.add(temp);
        }
        return resultStatistic;
    }
}
