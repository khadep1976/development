package com.wk.wellnessdev.development.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.wk.wellnessdev.development.model.Exercise;
@EnableJpaRepositories
@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

}
