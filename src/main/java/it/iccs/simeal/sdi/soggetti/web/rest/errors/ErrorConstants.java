package it.iccs.simeal.sdi.soggetti.web.rest.errors;

import java.net.URI;

public final class ErrorConstants {

    public static final String ERR_CONCURRENCY_FAILURE = "error.concurrencyFailure";
    public static final String ERR_VALIDATION = "error.validation";
    public static final String PROBLEM_BASE_URL = "https://www.jhipster.tech/problem";
    public static final URI DEFAULT_TYPE = URI.create(PROBLEM_BASE_URL + "/problem-with-message");
    public static final URI CONSTRAINT_VIOLATION_TYPE = URI.create(PROBLEM_BASE_URL + "/constraint-violation");

    // Errori di validazione 
    public static final String TIT_ERR_VAL = "Errore di Validazione";
    // Codici
    public static final String COD_VAL_001 = "VAL-ERR-001";
    public static final String COD_VAL_002 = "VAL-ERR-002";
    public static final String COD_VAL_003 = "VAL-ERR-003";
    public static final String COD_VAL_004 = "VAL-ERR-004";
    public static final String COD_VAL_005 = "VAL-ERR-005";
    public static final String COD_VAL_006 = "VAL-ERR-006";
    public static final String COD_VAL_007 = "VAL-ERR-007";
    
    // Codici
    public static final String DES_VAL_001 = "L'input non è compilato.";
    public static final String DES_VAL_002 = "Occorre specificare il codice fiscale del soggetto da cercare. Esempio: 'codiceFiscale' : 'AAABBB10C20D123E'";
    public static final String DES_VAL_003 = "Codice fiscale non valido, lunghezza diversa da 16.";
    public static final String DES_VAL_004 = "Indicare se estrarre o meno i componenti del nucleo familiare. Esempio: 'estraiSoggettiNucleoFamiliare' : false";
    public static final String DES_VAL_005 = "Compilare i dati del richiedente.";
    public static final String DES_VAL_006 = "Compilare il Codice Fiscale del richiedente. Esempio: 'datiRichiedente.cfRichiedente' : 'AAABBB10C20D123E'";
    public static final String DES_VAL_007 = "Compilare l'Ente del richiedente. Esempio: 'datiRichiedente.ente' : 'ASP Palermo'";
    
    // Errori di elaborazione
    public static final String TIT_ERR_ELB = "Errore di Elaborazione";
    // Codici
    public static final String COD_ELB_001 = "ELB-ERR-001";
    
    // Descrizioni
    public static final String DES_ELB_001 = "Soggetto non trovato.";

    // Errori di pubblicazione eventi
    public static final String TIT_ERR_PUB = "Errore di Pubblicazione Evento";
    // Codici
    public static final String COD_PUB_001 = "PUB-ERR-001";
    public static final String COD_PUB_002 = "PUB-ERR-002";
    // Descrizioni
    public static final String DES_PUB_001 = "Errore nell'invio dell'evento al message broker.";
    public static final String DES_PUB_002 = "Timeout o interruzione nel collegamento con il message broker.";

    private ErrorConstants() {
    }
}
