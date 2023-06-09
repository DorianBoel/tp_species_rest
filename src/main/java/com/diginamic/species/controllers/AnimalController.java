package com.diginamic.species.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginamic.species.dto.AnimalDTO;
import com.diginamic.species.entities.Animal;
import com.diginamic.species.services.AnimalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<AnimalDTO> getAll() {
        return animalService.findAll();
    }

    @GetMapping("{id}")
    public AnimalDTO get(@PathVariable Integer id) {
        return animalService.findById(id);
    }

    @PostMapping
    public Animal add(@RequestBody @Valid Animal animal) {
        return animalService.create(animal);
    }

    @PutMapping("{id}")
    public Animal update(@PathVariable Integer id, @RequestBody @Valid Animal animal) {
        return animalService.update(animal);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        animalService.delete(id);
    }

}
