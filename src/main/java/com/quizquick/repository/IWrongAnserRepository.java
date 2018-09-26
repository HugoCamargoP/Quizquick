package com.quizquick.repository;

import com.quizquick.entities.WrongAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWrongAnserRepository extends JpaRepository<WrongAnswer, Integer> {
}
