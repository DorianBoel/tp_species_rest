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

import com.diginamic.species.dto.PersonDTO;
import com.diginamic.species.entities.Person;
import com.diginamic.species.services.PersonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<PersonDTO> getAll() {
        return personService.findAll();
    }

    @GetMapping("{id}")
    public PersonDTO get(@PathVariable Integer id) {
        return personService.findById(id);
    }

    @PostMapping
    public Person add(@RequestBody @Valid Person person) {
        return personService.create(person);
    }

    @PutMapping("{id}")
    public Person update(@PathVariable Integer id, @RequestBody @Valid Person person) {
        return personService.update(person);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        personService.delete(id);
    }

}
