package com.diginamic.species.entities;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Species {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Length(max = 50)
    private String commonName;

    @NotBlank
    @Length(max = 200)
    private String latinName;

    public Species(String commonName, String latinName) {
        this.commonName = commonName;
        this.latinName = latinName;
    }

    @Override
    public String toString() {
        return new StringBuilder(getClass().getSimpleName() + ": ")
            .append("id = " + id)
            .append(", common name = " + commonName )
            .append(", scientific name = " + latinName)
            .toString();
    }

}
