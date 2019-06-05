package com.alex.springv2.service;

import com.alex.springv2.domain.Entity.Question;
import com.alex.springv2.domain.Entity.Test;

import java.util.List;
import java.util.Optional;

public interface TestService {
    List<Test> getAll();
    Test findById(Long id);
    List<Question> findAllByTestId(Long id);
}
