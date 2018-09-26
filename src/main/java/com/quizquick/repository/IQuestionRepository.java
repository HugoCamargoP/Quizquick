package com.quizquick.repository;

import com.quizquick.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionRepository extends JpaRepository<Question, Integer> {
}
