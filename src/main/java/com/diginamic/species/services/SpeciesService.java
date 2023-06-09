package com.diginamic.species.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.diginamic.species.dto.SpeciesDTO;
import com.diginamic.species.entities.Species;
import com.diginamic.species.exception.EntityNotFoundException;
import com.diginamic.species.exception.EntityUpdateDiffIdException;
import com.diginamic.species.exception.EntityUpdateNoIdException;
import com.diginamic.species.exception.NewEntityHasIdException;
import com.diginamic.species.mappers.SpeciesMapper;
import com.diginamic.species.repositories.SpeciesRepository;

import jakarta.validation.Valid;

@Service
public class SpeciesService {

    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired SpeciesMapper speciesMapper;

    private SpeciesDTO toDTO(Species species) {
        return speciesMapper.toDTO(species);
    }

    public Page<SpeciesDTO> findAll(Pageable pageable) {
        return speciesRepository.findAll(pageable)
            .map(this::toDTO);
    }

    public SpeciesDTO findById(Integer id) {
        Species found = speciesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return toDTO(found);
    }

    public SpeciesDTO create(@Valid Species newSpecies) {
        if (newSpecies.getId() != null)
            throw new NewEntityHasIdException();
        return toDTO(speciesRepository.save(newSpecies));
    }

    public SpeciesDTO update(Integer id, @Valid Species updatedSpecies) {
        if (updatedSpecies.getId() == null)
            throw new EntityUpdateNoIdException();
        if (!updatedSpecies.getId().equals(id))
            throw new EntityUpdateDiffIdException();
        return toDTO(speciesRepository.save(updatedSpecies));
    }

    public void delete(Integer id) {
        if (!speciesRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        speciesRepository.deleteById(id);
    }

}
