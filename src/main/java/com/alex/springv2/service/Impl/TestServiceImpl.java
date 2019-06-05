package com.alex.springv2.service.Impl;

import com.alex.springv2.domain.Entity.Question;
import com.alex.springv2.domain.Entity.Test;
import com.alex.springv2.repositories.QuestionRepository;
import com.alex.springv2.repositories.TestRepository;
import com.alex.springv2.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestRepository testRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<Test> getAll() {
        return testRepository.findAll();
    }

    @Override
    public Test findById(Long id) {
        Optional<Test> temp = testRepository.findById(id);
        if (temp.isPresent()) {
            return temp.get();
        } else {
            throw new RuntimeException("Test with id : " + id + " not found");
        }
    }

    @Override
    public List<Question> findAllByTestId(String chosenTest) {
        String[] splitted = chosenTest.split("\\s\\|\\s");
        long id = Long.parseLong(splitted[0]);
        return questionRepository.findAllByTestId(id);
    }
}
