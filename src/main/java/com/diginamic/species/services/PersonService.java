package com.diginamic.species.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.diginamic.species.dto.PersonDTO;
import com.diginamic.species.entities.Person;
import com.diginamic.species.exception.EntityNotFoundException;
import com.diginamic.species.exception.EntityUpdateDiffIdException;
import com.diginamic.species.exception.EntityUpdateNoIdException;
import com.diginamic.species.exception.NewEntityHasIdException;
import com.diginamic.species.mappers.PersonMapper;
import com.diginamic.species.repositories.PersonRepository;

import jakarta.validation.Valid;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    private PersonDTO toDTO(Person person) {
        return personMapper.toDTO(person);
    }

    public Page<PersonDTO> findAll(Pageable pageable) {
        return personRepository.findAll(pageable)
            .map(this::toDTO);
    }

    public PersonDTO findById(Integer id) {
        Person found = personRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return toDTO(found);
    }

    public PersonDTO create(@Valid Person newPerson) {
        if (newPerson.getId() != null)
            throw new NewEntityHasIdException();
        return toDTO(personRepository.save(newPerson));
    }

    public PersonDTO update(Integer id, @Valid Person updatedPerson) {
        if (updatedPerson.getId() == null)
            throw new EntityUpdateNoIdException();
        if (!updatedPerson.getId().equals(id))
            throw new EntityUpdateDiffIdException();
        return toDTO(personRepository.save(updatedPerson));
    }

    public void delete(Integer id) {
        if (!personRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        personRepository.deleteById(id);
    }

}
