package com.wk.wellnessdev.development.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wk.wellnessdev.development.model.Goal;
import com.wk.wellnessdev.development.repository.GoalRepository;

@Service
public class GoalServiceIMPL implements GoalService{
	@Autowired
	GoalRepository goalRepository;//<-Field base injuction-not recognise so use constructor base injection
	
	public List<Goal> getAllGoal() {// get All Goal
		return goalRepository.findAll();
	}
		
	public Goal getGoal(Long id) {
		return goalRepository.findById(id).get();
	}
	
	public Goal createGoal(Goal goal ) {
		return goalRepository.save(goal);
	}
	
	
	public Goal updateGoal(Long id,Goal goal) {
		Goal updateGoal = goalRepository.findById(id).get();
		updateGoal.setTargetValue(goal.getTargetValue());
		updateGoal.setTargetSet(goal.isTargetSet());
		updateGoal.setProgress(goal.getProgress());
		goalRepository.save(updateGoal);
		return updateGoal;
	}
	
	public void deleteGoal(Long id) {
		Goal deleteGoal = goalRepository.findById(id).get();
		goalRepository.delete(deleteGoal);
	}
}