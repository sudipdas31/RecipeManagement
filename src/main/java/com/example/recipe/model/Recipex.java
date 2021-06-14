package com.example.recipe.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="recipex")
@Data
//This is the main/current recipe class.
public class Recipex {
	@Id //Primary key
	private Long id;
	private String created=LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
	private String ingredients;
	private String instructions;
	private String name;
	private int servings;
	private String category="non vegan";
}
