package com.traineemgtapp.util;

import com.traineemgtapp.dto.TraineeDto;
import com.traineemgtapp.entities.Trainee;

public class TraineeConverter {

    public static TraineeDto convertToTraineeDto(Trainee trainee) {

        if (trainee == null) {
            return null;
        }

        TraineeDto dto = new TraineeDto();
        dto.setId(trainee.getId());
        dto.setName(trainee.getName());
        dto.setAge(trainee.getAge());
        dto.setMarks(trainee.getMarks());

        return dto;
    }

    public static Trainee convertToTrainee(TraineeDto dto) {

        if (dto == null) {
            return null;
        }

        Trainee trainee = new Trainee();
        trainee.setId(dto.getId());
        trainee.setName(dto.getName());
        trainee.setAge(dto.getAge());
        trainee.setMarks(dto.getMarks());

        return trainee;
    }
}
