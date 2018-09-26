package com.quizquick.repository;

import com.quizquick.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITopicRepository extends JpaRepository<Topic, Integer> {
}
