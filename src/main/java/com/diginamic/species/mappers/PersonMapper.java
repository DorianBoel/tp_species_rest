package com.diginamic.species.mappers;

import org.springframework.stereotype.Component;

import com.diginamic.species.dto.PersonDTO;
import com.diginamic.species.entities.Person;

@Component
public class PersonMapper {

    public PersonDTO toDTO(Person person) {
        PersonDTO dto = new PersonDTO();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setAge(person.getAge());
        dto.setAnimals(person.getAnimals().stream().map(PersonDTO.PersonAnimalDTO::new).toList());
        return dto;
    }

}
