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

import com.wk.wellnessdev.development.model.Goal;
import com.wk.wellnessdev.development.service.GoalService;


@RestController
public class GoalCRUDController {

	@Autowired
	private GoalService goalService;
	
	@GetMapping("/goal")
	public List<Goal> getAllGoal() {
		return goalService.getAllGoal();
	}

	@GetMapping("/goal/{goalId}")
	public Goal getGoal(@PathVariable Long goalId) {
		return goalService.getGoal(goalId);

	}
	
	@PostMapping("/goal/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createGoal(@RequestBody Goal goal ) {
		System.out.println("Goal created successfully");
		goalService.createGoal(goal);
	}
	
	
	
	@PutMapping("/goal/update/{goalId}")
	public Goal updateGoal(@PathVariable Long goalId,@RequestBody Goal goal) {
		System.out.println("Goal updated successfully");
		return goalService.updateGoal(goalId,goal);
	}
	
	
	@DeleteMapping("/goal/delete/{goalId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteGoal(@PathVariable Long goalId) {
		System.out.println("Goal deleted successfully");
		goalService.deleteGoal(goalId);
	}
	

}
