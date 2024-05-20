package com.wk.wellnessdev.development.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.wk.wellnessdev.development.model.Exercise;
import com.wk.wellnessdev.development.repository.ExerciseRepository;

@Controller
public class SetExerciseController {
	@Autowired
    private ExerciseRepository exerciseRepository;

	
	@GetMapping("/selectexercise")
	public String getExePage(@ModelAttribute("exercise") Exercise exercise) {
		return "setexercise";
	}
	
	@PostMapping("/selectexercise")
	public String saveExercise(@ModelAttribute("exercise") Exercise exercise, Model model) {
		exerciseRepository.save(exercise);
		model.addAttribute("message", "Exercise selected Successfully");
		return "setexercise";
	}
	
	
	@GetMapping("/displaye")
	public String exercisePage(Model model) {
		List<Exercise> listOfExercise= exerciseRepository.findAll();
		model.addAttribute("exercise", listOfExercise);
		return "exercise";
	}
	
	

}