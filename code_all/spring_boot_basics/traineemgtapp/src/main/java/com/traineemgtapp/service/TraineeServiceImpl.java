package com.traineemgtapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.traineemgtapp.dto.TraineeDto;
import com.traineemgtapp.entities.Trainee;
import com.traineemgtapp.exceptions.ResourceNotFoundAcception;
import com.traineemgtapp.repo.TraineeRepo;
import com.traineemgtapp.util.TraineeConverter;


@Service
@Transactional
public class TraineeServiceImpl implements TraineeService {

	private TraineeRepo traineeRepo;

	public TraineeServiceImpl(TraineeRepo traineeRepo) {
		this.traineeRepo = traineeRepo;
	}

	@Override
	public List<TraineeDto> getAll() {
		return traineeRepo.findAll().stream().map(TraineeConverter::convertToTraineeDto).toList();
	}

	@Override
	public TraineeDto addTrainee(TraineeDto traineeDto) {
		return TraineeConverter.convertToTraineeDto(traineeRepo.save(TraineeConverter.convertToTrainee(traineeDto)));
	}

	@Override
	public TraineeDto getById(int id) {
		return traineeRepo.findById(id).map(TraineeConverter::convertToTraineeDto)
				.orElseThrow(() -> new ResourceNotFoundAcception("trainee not found"));
	}

	@Override
	public TraineeDto updateTrainee(int id, TraineeDto traineeDto) {

		Trainee traineeToUpdate = traineeRepo.findById(id).orElseThrow(() -> new RuntimeException("Trainee not found"));

		traineeToUpdate.setName(traineeDto.getName());
		traineeToUpdate.setAge(traineeDto.getAge());
		traineeToUpdate.setMarks(traineeDto.getMarks());

		Trainee updatedTrainee = traineeRepo.save(traineeToUpdate);

		return TraineeConverter.convertToTraineeDto(updatedTrainee);
	}

	@Override
	public TraineeDto deleteTrainee(int id) {

		Trainee traineeToDelete = traineeRepo.findById(id).orElseThrow(() -> new RuntimeException("Trainee not found"));

		traineeRepo.delete(traineeToDelete);

		return TraineeConverter.convertToTraineeDto(traineeToDelete);
	}

	@Override
	public List<TraineeDto> getByName(String name) {

		List<Trainee> trainees = traineeRepo.getTraineeByName(name);

		return trainees.stream().map(TraineeConverter::convertToTraineeDto).toList();
	}

}
