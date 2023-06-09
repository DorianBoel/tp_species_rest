package com.diginamic.species.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diginamic.species.dto.AnimalDTO;
import com.diginamic.species.entities.Animal;
import com.diginamic.species.mappers.AnimalMapper;
import com.diginamic.species.repositories.AnimalRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AnimalMapper animalMapper;

    public List<AnimalDTO> findAll() {
        return animalRepository.findAll().stream()
            .map(animalMapper::toDTO)
            .toList();
    }

    public AnimalDTO findById(Integer id) {
        return animalMapper.toDTO(animalRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public Animal create(@Valid Animal newAnimal) {
        return animalRepository.save(newAnimal);
    }

    public Animal update(@Valid Animal updatedAnimal) {
        return animalRepository.save(updatedAnimal);
    }

    public void delete(Integer id) {
        animalRepository.deleteById(id);
    }

}
