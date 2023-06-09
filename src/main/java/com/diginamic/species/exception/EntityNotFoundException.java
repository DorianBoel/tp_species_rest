package com.diginamic.species.exception;

public class EntityNotFoundException extends jakarta.persistence.EntityNotFoundException {

    public EntityNotFoundException() {
        super("Aucune entité correspondante");
    }

}
