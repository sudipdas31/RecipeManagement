package com.example.gamasg.recipe;

import com.example.gamasg.recipe.controller.RecipexController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RecipeApplicationTests {

	@Autowired
	RecipexController recipexController;

	@Test
	void contextLoads() {
		assertThat(recipexController).isNotNull();
	}

}
