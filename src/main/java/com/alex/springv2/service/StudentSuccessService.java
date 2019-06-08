package com.alex.springv2.service;

import com.alex.springv2.domain.entity.StudentSuccess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface StudentSuccessService {
    void saveCurrentResult(Map<String,Boolean> resultTest, String testInfo, String userName);
    Page<StudentSuccess> findAllByUserName(String userName, Pageable pageable);
}
