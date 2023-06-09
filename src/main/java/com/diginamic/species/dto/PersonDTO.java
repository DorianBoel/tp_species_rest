package com.diginamic.species.dto;

import java.util.List;

import com.diginamic.species.entities.Animal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PersonDTO {

    private Integer id;

    private String firstName;

    private String lastName;

    private int age;

    private List<PersonAnimalDTO> animals;

    @NoArgsConstructor
    @Getter
    @Setter
    public static class PersonAnimalDTO {

        private Integer id;

        private String identity;

        public PersonAnimalDTO(Animal animal) {
            id = animal.getId();
            identity = animal.getIdentity();
        }

    }

}
