package com.diginamic.species.exception;

public abstract class EntityRequestException extends RuntimeException {

    public EntityRequestException(String message) {
        super(message);
    }

}
