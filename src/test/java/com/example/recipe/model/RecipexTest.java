package com.example.recipe.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

class RecipexTest {

    @Test
    void recipeCreationTimeWouldBeTheCurrentDateTimeByDefault() {
        // Given
        Recipex recipex = new Recipex();
        recipex.setId(105L);
        //Then
        assertThat(recipex.getCreated()).isEqualTo(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
    }

    @Test
    void recipeWillBeUpdatedToCategoryFromDefaultNonVeganCategory() {
        //Given
        Recipex recipex = new Recipex();
        //When
        recipex.setId(101L);
        recipex.setIngredients("test ingredients");
        recipex.setInstructions("test instructions");
        recipex.setName("test recipe");
        recipex.setCreated(LocalDateTime.now().plusHours(1).format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        recipex.setCategory("vegan");
        //Then
        assertThat(recipex.getCategory()).isEqualTo("vegan");
    }

    @Test
    void recipeUpdateTimeWouldBeSetToCurrentDateTime() {
        //Given
        Recipex recipex = new Recipex();
        //When
        recipex.setId(101L);
        recipex.setIngredients("test ingredients");
        recipex.setInstructions("test instructions");
        recipex.setName("test recipe");
        recipex.setCategory("vegan");
        //Then
        assertThat(recipex.getCreated()).isEqualTo(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
    }

    @Test
    void recipeCategoryIsByDefaultNonVegan(){
        //Given
        Recipex recipex=new Recipex();
        //Then
        assertThat(recipex.getCategory()).isEqualTo("non vegan");
    }
}
