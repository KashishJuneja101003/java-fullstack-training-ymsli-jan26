package com.traineemgtapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traineemgtapp.dto.TraineeDto;
import com.traineemgtapp.service.TraineeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "v1")
public class TraineeController {

    private final TraineeService traineeService;

    @GetMapping(path = "trainees")
    public ResponseEntity<List<TraineeDto>> getAll() {
        return ResponseEntity.ok(traineeService.getAll());
    }

    @GetMapping(path = "trainees/{id}")
    public ResponseEntity<TraineeDto> getById(@PathVariable(name = "id") int id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(traineeService.getById(id));
    }

    @PostMapping(path = "trainees")
    public ResponseEntity<TraineeDto> addTrainee( @RequestBody TraineeDto traineeDto) {
        TraineeDto saved = traineeService.addTrainee(traineeDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saved);
    }

    @PutMapping(path = "trainees/{id}")
    public ResponseEntity<TraineeDto> updateById(
            @PathVariable(name = "id") int id,
             @RequestBody TraineeDto traineeDto) {

        TraineeDto updated = traineeService.updateTrainee(id, traineeDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updated);
    }

    @DeleteMapping(path = "trainees/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") int id) {
        traineeService.deleteTrainee(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
