package com.wk.wellnessdev.development.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Exercise {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long exerciseId;//primary key
	
	private String exerciseName;	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime startTime;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime endTime;
	
    private Long duration;	// = endTime - startTime;//in min 
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;
	

	public Exercise() {
		
	}

	
	public Exercise(Long exerciseId, String exerciseName, LocalTime startTime, LocalTime endTime, Long duration, LocalDate date,
			 User user) {

		this.exerciseId = exerciseId;
		this.exerciseName = exerciseName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
		this.date = date;
		this.user = user;
	}


	public Long getExerciseId() {
		return exerciseId;
	}


	public void setExerciseId(Long exerciseId) {
		this.exerciseId = exerciseId;
	}


	public String getExerciseName() {
		return exerciseName;
	}


	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}


	public LocalTime getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}


	public LocalTime getEndTime() {
		return endTime;
	}


	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}


	public Long getDuration() {
		return duration;
	}


	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}	
}