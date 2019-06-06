package com.alex.springv2.repositories.impl;

import com.alex.springv2.domain.entity.StudentSuccess;
import com.alex.springv2.repositories.StudentSuccessRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class StudentSuccessRepositoryCustomImpl implements StudentSuccessRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<StudentSuccess> findAllByUserId(long id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM spring.student_success as ss " +
                "WHERE ss.user_id = ?", StudentSuccess.class);
        query.setParameter(1, id);
        return query.getResultList();
    }
}
