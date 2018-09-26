package com.quizquick.repository;

import com.quizquick.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IModuleRepository extends JpaRepository<Module, Integer> {
}
