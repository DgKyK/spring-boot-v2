package com.alex.springv2.service;

import com.alex.springv2.domain.entity.Question;
import com.alex.springv2.domain.entity.Test;

import java.util.List;

public interface TestService {
    List<Test> getAll();
    Test findById(Long id);
    List<Question> findAllByTestId(String chosenTest);
}
