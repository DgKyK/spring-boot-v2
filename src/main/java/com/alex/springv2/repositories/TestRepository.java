package com.alex.springv2.repositories;

import com.alex.springv2.domain.Entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {

}
