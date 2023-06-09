package com.diginamic.species.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diginamic.species.dto.SpeciesDTO;
import com.diginamic.species.entities.Species;
import com.diginamic.species.mappers.SpeciesMapper;
import com.diginamic.species.repositories.SpeciesRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class SpeciesService {

    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired SpeciesMapper speciesMapper;

    public List<SpeciesDTO> findAll() {
        return speciesRepository.findAll().stream()
            .map(speciesMapper::toDTO)
            .toList();
    }

    public SpeciesDTO findById(Integer id) {
        return speciesMapper.toDTO(speciesRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public Species create(@Valid Species newSpecies) {
        return speciesRepository.save(newSpecies);
    }

    public Species update(@Valid Species updatedSpecies) {
        return speciesRepository.save(updatedSpecies);
    }

    public void delete(Integer id) {
        speciesRepository.deleteById(id);
    }

}
