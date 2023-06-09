package com.diginamic.species.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.diginamic.species.dto.AnimalDTO;
import com.diginamic.species.entities.Animal;
import com.diginamic.species.exception.EntityNotFoundException;
import com.diginamic.species.exception.EntityUpdateDiffIdException;
import com.diginamic.species.exception.EntityUpdateNoIdException;
import com.diginamic.species.exception.NewEntityHasIdException;
import com.diginamic.species.mappers.AnimalMapper;
import com.diginamic.species.repositories.AnimalRepository;

import jakarta.validation.Valid;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AnimalMapper animalMapper;

    private AnimalDTO toDTO(Animal animal) {
        return animalMapper.toDTO(animal);
    }

    public Page<AnimalDTO> findAll(Pageable pageable) {
        return animalRepository.findAll(pageable)
            .map(this::toDTO);
    }

    public AnimalDTO findById(Integer id) {
        Animal found = animalRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return toDTO(found);
    }

    public AnimalDTO create(@Valid Animal newAnimal) {
        if (newAnimal.getId() != null)
            throw new NewEntityHasIdException();
        return toDTO(animalRepository.save(newAnimal));
    }

    public AnimalDTO update(Integer id, @Valid Animal updatedAnimal) {
        if (updatedAnimal.getId() == null)
            throw new EntityUpdateNoIdException();
        if (!updatedAnimal.getId().equals(id))
            throw new EntityUpdateDiffIdException();
        return toDTO(animalRepository.save(updatedAnimal));
    }

    public void delete(Integer id) {
        if (!animalRepository.existsById(id))
            throw new EntityNotFoundException();
        animalRepository.deleteById(id);
    }

}
