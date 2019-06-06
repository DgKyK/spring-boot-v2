package com.alex.springv2.service;

import com.alex.springv2.domain.entity.StudentSuccess;

import java.util.List;
import java.util.Map;

public interface StudentSuccessService {
    void saveCurrentResult(Map<String,Boolean> resultTest, String testInfo, String userName);
    List<StudentSuccess> findAllByUserName(String userName);
}
