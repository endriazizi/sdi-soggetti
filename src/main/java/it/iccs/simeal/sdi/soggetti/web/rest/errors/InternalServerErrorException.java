package it.iccs.simeal.sdi.soggetti.web.rest.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InternalServerErrorException() {
    }

    public InternalServerErrorException(String message) {
        super(message);
    }
}
