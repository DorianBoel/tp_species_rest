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

import com.diginamic.species.dto.SpeciesDTO;
import com.diginamic.species.entities.Species;
import com.diginamic.species.services.SpeciesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/species")
public class SpeciesController {

    @Autowired
    private SpeciesService speciesService;

    @GetMapping
    public List<SpeciesDTO> getAll() {
        return speciesService.findAll();
    }

    @GetMapping("{id}")
    public SpeciesDTO get(@PathVariable Integer id) {
        return speciesService.findById(id);
    }

    @PostMapping
    public Species add(@RequestBody @Valid Species species) {
        return speciesService.create(species);
    }

    @PutMapping("{id}")
    public Species update(@PathVariable Integer id, @RequestBody @Valid Species species) {
        return speciesService.update(species);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        speciesService.delete(id);
    }

}
