package com.alex.springv2.repositories;

import com.alex.springv2.domain.entity.StudentSuccess;

import java.util.List;

public interface StudentSuccessRepositoryCustom {
    List<StudentSuccess> findAllByUserId(long id);
}
