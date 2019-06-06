package com.alex.springv2.repositories;

import com.alex.springv2.domain.entity.StudentSuccess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentSuccessRepository extends JpaRepository<StudentSuccess, Long>, StudentSuccessRepositoryCustom {
}
