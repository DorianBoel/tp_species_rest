package com.diginamic.species.mappers;

import org.springframework.stereotype.Component;

import com.diginamic.species.dto.SpeciesDTO;
import com.diginamic.species.entities.Species;

@Component
public class SpeciesMapper {

    public SpeciesDTO toDTO(Species species) {
        SpeciesDTO dto = new SpeciesDTO();
        dto.setId(species.getId());
        return dto;
    }

}
