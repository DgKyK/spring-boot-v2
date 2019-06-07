package com.alex.springv2.repositories;

import com.alex.springv2.domain.entity.StudentSuccess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentSuccessRepository extends JpaRepository<StudentSuccess, Long> {
    List<StudentSuccess> findAllByUser_Id(long id);
}
