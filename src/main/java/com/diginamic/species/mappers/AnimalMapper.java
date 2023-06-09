package com.diginamic.species.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diginamic.species.dto.AnimalDTO;
import com.diginamic.species.entities.Animal;

@Component
public class AnimalMapper {

    @Autowired
    private SpeciesMapper speciesMapper;

    public AnimalDTO toDTO(Animal animal) {
        AnimalDTO dto = new AnimalDTO();
        dto.setId(animal.getId());
        dto.setName(animal.getName());
        dto.setColor(animal.getColor());
        dto.setSex(animal.getSex().getAbbreviation());
        dto.setSpecies(speciesMapper.toDTO(animal.getSpecies()));
        dto.setOwners(animal.getOwners().stream().map(AnimalDTO.AnimalOwnerDTO::new).toList());
        return dto;
    }

}
