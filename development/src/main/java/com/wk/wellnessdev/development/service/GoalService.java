package com.wk.wellnessdev.development.service;

import java.util.List;

import com.wk.wellnessdev.development.model.Goal;

public interface GoalService {
	public List<Goal> getAllGoal();
	public Goal getGoal(Long goalId);
	public Goal createGoal(Goal goal);
	public Goal updateGoal(Long goalId,Goal goal);
	public void deleteGoal(Long goalId);

}