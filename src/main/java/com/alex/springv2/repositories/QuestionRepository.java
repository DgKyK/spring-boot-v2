package com.alex.springv2.repositories;

import com.alex.springv2.domain.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByTest_Id(long id);
}
