package com.alex.springv2.service.impl;

import com.alex.springv2.domain.entity.Question;
import com.alex.springv2.domain.entity.Test;
import com.alex.springv2.repositories.QuestionRepository;
import com.alex.springv2.repositories.TestRepository;
import com.alex.springv2.service.TestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {

    private TestRepository testRepository;
    private QuestionRepository questionRepository;
    private Logger logger = LogManager.getLogger(this.getClass());


    @Autowired
    public TestServiceImpl(TestRepository testRepository, QuestionRepository questionRepository) {
        this.testRepository = testRepository;
        this.questionRepository = questionRepository;
    }

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
            logger.warn("Test with id : " + id + " not found");
            throw new RuntimeException("Test with id : " + id + " not found");
            //TODO find better way to resolve this case
        }
    }

    @Override
    public List<Question> findAllByTestId(String chosenTest) {
        String[] splitted = chosenTest.split("\\s\\|\\s");
        long id = Long.parseLong(splitted[0]);
        return questionRepository.findAllByTest_Id(id);
    }
}
