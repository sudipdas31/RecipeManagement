package com.example.recipe.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;
import javax.validation.Valid;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.recipe.model.Recipex;
import com.example.recipe.repository.RecipexRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "${client.url}")
@Log4j2
public class RecipexController {

    private RecipexRepository recipexRepository;

    public RecipexController(RecipexRepository recipexRepository) {
        super();
        this.recipexRepository = recipexRepository;
    }

    @GetMapping("/recipes")
    public Collection<Recipex> recipes() {
        //Equivalent to select * from recipex
        log.debug("All Recipes fetched");
        return recipexRepository.findAll();
    }

    @GetMapping("/recipex/{id}")
    public ResponseEntity<Recipex> getRecipex(@PathVariable Long id) {
        Optional<Recipex> recipex = recipexRepository.findById(id);
        log.info("Recipe for id: " + id);
        return recipex.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/recipex")
    public ResponseEntity<Recipex> createRecipex(@Valid @RequestBody Recipex recipex) throws URISyntaxException {
        Recipex result = recipexRepository.save(recipex);
        log.info("recipe created with name: " + recipex.getName());
        return ResponseEntity.created(new URI("/api/recipex" + result.getId())).body(result);
    }

    @PutMapping("/recipex/{id}")
    public ResponseEntity<Recipex> updateRecipex(@Valid @RequestBody Recipex recipex, @PathVariable Long id) {
        if (!recipex.getId().equals(id)) {
            log.info("id does not exist");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Recipex result = recipexRepository.save(recipex);
        log.info("recipe updated with name: " + recipex.getName());
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/recipex/{id}")
    public ResponseEntity<Recipex> deleteRecipex(@PathVariable Long id) {
        log.info("recipe delete with id: " + id);
        recipexRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
