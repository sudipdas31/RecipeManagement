package com.example.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.recipe.model.Recipex;

public interface RecipexRepository extends JpaRepository<Recipex, Long> {
	
}
