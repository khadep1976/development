package com.wk.wellnessdev.development.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.wk.wellnessdev.development.model.Goal;
import com.wk.wellnessdev.development.repository.GoalRepository;

@Controller
public class SetGoalController {
	@Autowired
    private GoalRepository goalRepository;

	
	@GetMapping("/selectgoal")
	public String getGoalPage(@ModelAttribute("goal") Goal goal) {
		return "setgoal";
	}
	
	@PostMapping("/selectgoal")
	public String saveGoal(@ModelAttribute("goal") Goal goal, Model model) {
		goalRepository.save(goal);
		model.addAttribute("message", "Goal set Successfully");
		return "setgoal";
	}
	
	
	@GetMapping("/displayg")
	public String goalPage(Model model) {
		List<Goal> listOfGoal= goalRepository.findAll();
		model.addAttribute("goal", listOfGoal);
		return "goal";
	}
	
	

}