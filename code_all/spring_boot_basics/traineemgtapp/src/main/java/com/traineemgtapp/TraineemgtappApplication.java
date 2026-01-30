package com.traineemgtapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.traineemgtapp.entities.Trainee;
import com.traineemgtapp.repo.TraineeRepo;

import jakarta.persistence.EntityManagerFactory;

@SpringBootApplication
public class TraineemgtappApplication implements CommandLineRunner {

	@Autowired
	private TraineeRepo traineeRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(TraineemgtappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//traineeRepo.save(Trainee.builder().name("raj").age(23).marks(67).build());
	}

}
