package it.iccs.simeal.sdi.domande.web.rest.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConstraintsViolateException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ConstraintsViolateException() {
    }

    public ConstraintsViolateException(String message) {
        super(message);
    }
    
}