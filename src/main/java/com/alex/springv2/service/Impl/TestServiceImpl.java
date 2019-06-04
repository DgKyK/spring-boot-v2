package com.alex.springv2.service.Impl;

import com.alex.springv2.domain.Entity.Test;
import com.alex.springv2.repositories.TestRepository;
import com.alex.springv2.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestRepository testRepository;

    @Override
    public List<Test> getAll() {
        return testRepository.findAll();
    }
}
