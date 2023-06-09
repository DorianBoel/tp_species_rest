package com.diginamic.species.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityUpdateDiffIdException extends EntityRequestException {

    private static final long serialVersionUID = 1L;

	public EntityUpdateDiffIdException() {
		super("L'ID de l'url ne correspond pas");
	}

}
