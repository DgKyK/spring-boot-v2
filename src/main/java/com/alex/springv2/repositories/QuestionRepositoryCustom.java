package com.alex.springv2.repositories;

import com.alex.springv2.domain.Entity.Question;

import java.util.List;

public interface QuestionRepositoryCustom {
    List<Question> findAllByTestId(long testId);
}
