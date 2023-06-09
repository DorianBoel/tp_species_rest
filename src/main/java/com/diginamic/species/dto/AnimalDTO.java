package com.diginamic.species.dto;

import java.util.List;

import com.diginamic.species.entities.Person;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AnimalDTO {

    private Integer id;

    private String name;

    private String color;

    private String sex;

    private SpeciesDTO species;

    private List<AnimalOwnerDTO> owners;

    @NoArgsConstructor
    @Getter
    @Setter
    static public class AnimalOwnerDTO {

        private Integer id;

        private String name;

        public AnimalOwnerDTO(Person person) {
            id = person.getId();
            name = person.getFullName();
        }

    }

}
