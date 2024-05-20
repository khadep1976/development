package com.wk.wellnessdev.development.service;

import java.util.List;

import com.wk.wellnessdev.development.model.Exercise;

public interface ExerciseService {
	public List<Exercise> getAllExercise();
	public Exercise getExercise(Long exerciseId);
	public Exercise createExercise(Exercise exercise);
	public Exercise updateExercise(Long exerciseId,Exercise exercise);
	public void deleteExercise(Long exerciseId);
}
