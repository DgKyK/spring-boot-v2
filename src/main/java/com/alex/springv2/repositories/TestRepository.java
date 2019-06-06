package com.alex.springv2.repositories;

import com.alex.springv2.domain.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
