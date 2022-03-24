package it.iccs.simeal.sdi.domande.web.rest.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

    public UnauthorizedException() {
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
