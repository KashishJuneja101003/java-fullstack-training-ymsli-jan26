package com.traineemgtapp.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "trainee_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Trainee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer age;
	private Integer marks;
	
	public Trainee(String name, Integer age, Integer marks) {
		this.name = name;
		this.age = age;
		this.marks = marks;
	}
	
	
	
	
}
