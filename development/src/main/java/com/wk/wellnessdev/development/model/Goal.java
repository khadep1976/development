package com.wk.wellnessdev.development.model;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "goal")
public class Goal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long goalId;//primary key
	
	//private String goalName;//weekly,bi-weekly,3-weekly, monthly , daily,
	private Long targetValue;
	private boolean targetSet;//true false
	private String progress;//notYetStarted, InProgress,Completed -> based on the targetValue and duration from the exercise table
//	@Column(name = "exerciseId")
//	private Long exerciseId;//foreign key from Exercise
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exerciseId", referencedColumnName = "exerciseId")
	private Exercise exercise;
	
	public Goal() {
		
	}
	
	public Goal(Long targetValue, boolean targetSet, String progress,Goal goal) {
		
		this.targetValue = targetValue;
		this.targetSet = targetSet;
		this.progress = progress;
		//this.exerciseId = exerciseId;
	}

	public Long getGoalId() {
		return goalId;
	}

	public void setGoalId(Long goalId) {
		this.goalId = goalId;
	}

	public Long getTargetValue() {
		return targetValue;
	}

	public void setTargetValue(Long targetValue) {
		this.targetValue = targetValue;
	}

	public boolean isTargetSet() {
		return targetSet;
	}

	public void setTargetSet(boolean targetSet) {
		this.targetSet = targetSet;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}
	


}