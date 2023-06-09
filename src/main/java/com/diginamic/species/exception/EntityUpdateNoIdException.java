package com.diginamic.species.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityUpdateNoIdException extends EntityRequestException {

    private static final long serialVersionUID = 1L;

	public EntityUpdateNoIdException() {
		super("L'ID ne doit pas être vide");
	}

}
