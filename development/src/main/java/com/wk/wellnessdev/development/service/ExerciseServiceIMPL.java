package com.wk.wellnessdev.development.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wk.wellnessdev.development.model.Exercise;
import com.wk.wellnessdev.development.repository.ExerciseRepository;


@Service
public class ExerciseServiceIMPL implements ExerciseService{
	@Autowired
	ExerciseRepository exerciseRepository;//<-Field base injuction-not recognise so use constructor base injection
	
	public List<Exercise> getAllExercise() {// get All Exercise
		return exerciseRepository.findAll();
	}
		
	public Exercise getExercise(Long id) {
		return exerciseRepository.findById(id).get();
	}
	
	public Exercise createExercise(Exercise exercise ) {
		return exerciseRepository.save(exercise);
	}
	
	
	public Exercise updateExercise(Long id,Exercise exercise) {
		Exercise updateExercise = exerciseRepository.findById(id).get();
		updateExercise.setExerciseName(exercise.getExerciseName());
		updateExercise.setStartTime(exercise.getStartTime());
		updateExercise.setEndTime(exercise.getEndTime());
		updateExercise.setDuration(exercise.getDuration());
		updateExercise.setDate(exercise.getDate());
		exerciseRepository.save(updateExercise);
		return updateExercise;
	}
	
	public void deleteExercise(Long id) {
		Exercise deleteExercise = exerciseRepository.findById(id).get();
		exerciseRepository.delete(deleteExercise);
	}
}
