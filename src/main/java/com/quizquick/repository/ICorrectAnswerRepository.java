package com.quizquick.repository;

import com.quizquick.entities.CorrectAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICorrectAnswerRepository extends JpaRepository<CorrectAnswer, Integer> {
}
