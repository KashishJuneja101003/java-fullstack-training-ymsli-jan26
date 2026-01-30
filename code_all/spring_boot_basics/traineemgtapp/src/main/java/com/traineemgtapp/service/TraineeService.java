package com.traineemgtapp.service;

import java.util.List;

import com.traineemgtapp.dto.TraineeDto;
import com.traineemgtapp.entities.Trainee;

public interface TraineeService  {
	public List<TraineeDto> getAll();
	public TraineeDto addTrainee(TraineeDto trainee);
	public TraineeDto getById(int id);
	public TraineeDto updateTrainee(int id, TraineeDto traineeDto);
	public TraineeDto deleteTrainee(int id);
	public List<TraineeDto> getByName(String name);
}
