package com.traineemgtapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traineemgtapp.dto.TraineeDto;
import com.traineemgtapp.service.TraineeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TraineeController {

	private final TraineeService traineeService;
	
	@GetMapping(path = "trainees")
	public List<TraineeDto> getAll(){
		return traineeService.getAll();
	}
}
