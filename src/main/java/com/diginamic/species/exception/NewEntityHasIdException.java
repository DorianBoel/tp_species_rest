package com.diginamic.species.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NewEntityHasIdException extends EntityRequestException {

    private static final long serialVersionUID = 1L;

	public NewEntityHasIdException() {
		super("La nouvelle entité ne doit pas comprendre d'ID");
	}

}
