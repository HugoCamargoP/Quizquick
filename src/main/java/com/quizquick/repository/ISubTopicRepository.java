package com.quizquick.repository;

import com.quizquick.entities.SubTopic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubTopicRepository extends JpaRepository<SubTopic, Integer> {
}
