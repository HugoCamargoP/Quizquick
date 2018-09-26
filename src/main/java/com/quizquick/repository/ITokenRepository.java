package com.quizquick.repository;

import com.quizquick.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepository extends JpaRepository<Token, Integer> {
}
