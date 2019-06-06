package com.alex.springv2.repositories.impl;

import com.alex.springv2.domain.entity.Question;
import com.alex.springv2.repositories.QuestionRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class QuestionRepositoryCustomImpl implements QuestionRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Question> findAllByTestId(long testId) {
        Query query = entityManager.createNativeQuery("SELECT * FROM spring.questions as q " +
                "WHERE q.test_id = ?", Question.class);
        query.setParameter(1, testId);
        return query.getResultList();
    }
}
