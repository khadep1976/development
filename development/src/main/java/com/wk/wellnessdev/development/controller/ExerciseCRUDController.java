package com.wk.wellnessdev.development.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wk.wellnessdev.development.model.Exercise;
import com.wk.wellnessdev.development.service.ExerciseService;

@RestController
public class ExerciseCRUDController {

	@Autowired
	private ExerciseService exerciseService;
	
	@GetMapping("/exercise")
	public List<Exercise> getAllExercise() {
		return exerciseService.getAllExercise();
	}

	@GetMapping("/exercise/{exerciseId}")
	public Exercise getExercise(@PathVariable Long exerciseId) {
		return exerciseService.getExercise(exerciseId);

	}
	
	@PostMapping("/exercise/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createExercise(@RequestBody Exercise exercise ) {
		System.out.println("Exercise created successfully");
		exerciseService.createExercise(exercise);
	}
	
	
	
	@PutMapping("/exercise/update/{exerciseId}")
	public Exercise updateExercise(@PathVariable Long exerciseId,@RequestBody Exercise exercise) {
		System.out.println("Exercise updated successfully");
		return exerciseService.updateExercise(exerciseId,exercise);
	}
	
	
	@DeleteMapping("/exercise/delete/{exerciseId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteExercise(@PathVariable Long exerciseId) {
		System.out.println("Exercise deleted successfully");
		exerciseService.deleteExercise(exerciseId);
	}
	

}
