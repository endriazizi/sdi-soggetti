package it.iccs.simeal.sdi.domande.web.rest.errors;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.util.HashMap;
import java.util.Map;

public class RestApiException extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;
    
    private final String messaggio;
    private final String codice;
    private final String titolo;
    
    public RestApiException(String messaggio, String titolo, String codice) {
        this(messaggio, titolo, codice, decodeStatus(codice));
    }

    public RestApiException(String messaggio, String titolo, String codice, Status stato) {
        super(null, null, stato, null, null, null, null);
        this.messaggio = messaggio;
        this.codice = codice;
        this.titolo = titolo;
    }

    
    
	public String getMessaggioErrore() {
		return messaggio;
	}

	public String getCodiceErrore() {
		return codice;
	}

	public String getTitolo() {
		return titolo;
	}

	private static Map<String, Object> getAlertParameters(String messaggio, String codice, String titolo) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("messaggio",  messaggio);
        parameters.put("codice", codice);
        parameters.put("titolo", titolo);
        return parameters;
    }
	
	private static Status decodeStatus(String codice) {
		Status stato = null;
		switch (codice) {
		case ErrorConstants.COD_VAL_001:
		case ErrorConstants.COD_VAL_002:
		case ErrorConstants.COD_VAL_003:
		case ErrorConstants.COD_VAL_004:
		case ErrorConstants.COD_VAL_005:
		case ErrorConstants.COD_VAL_006:
		case ErrorConstants.COD_VAL_007:
			stato = Status.BAD_REQUEST;
			break; 
		case ErrorConstants.COD_ELB_001:
			stato = Status.NOT_FOUND;
			break;
		default:
			stato = Status.INTERNAL_SERVER_ERROR;
		}
		return stato;
	}
}
