package com.alex.springv2.repositories;

import com.alex.springv2.domain.entity.StudentSuccess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentSuccessRepository extends JpaRepository<StudentSuccess, Long> {
    Page<StudentSuccess> findAll(Pageable pageable);

    Page<StudentSuccess> findAllByUser_Id(long id, Pageable pageable);
}
