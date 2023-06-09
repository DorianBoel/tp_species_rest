package com.diginamic.species.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diginamic.species.dto.PersonDTO;
import com.diginamic.species.entities.Person;
import com.diginamic.species.mappers.PersonMapper;
import com.diginamic.species.repositories.PersonRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    public List<PersonDTO> findAll() {
        return personRepository.findAll().stream()
            .map(personMapper::toDTO)
            .toList();
    }

    public PersonDTO findById(Integer id) {
        return personMapper.toDTO(personRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public Person create(@Valid Person newPerson) {
        return personRepository.save(newPerson);
    }

    public Person update(@Valid Person updatedPerson) {
        return personRepository.save(updatedPerson);
    }

    public void delete(Integer id) {
        personRepository.deleteById(id);
    }

}
