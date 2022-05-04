package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.enumeration;

public enum TipologiaSoggetto {
    PERSONA_FISICA("Persona Fisica"),
    PERSONA_GIURIDICA("Persona Giuridica");

    private final String value;

    TipologiaSoggetto(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


///**
// * The StatoRiparti enumeration.
// */
//public enum StatoRiparti {
//    A("Aperta"),
//    D("Validata dal Distretto"),
//    R("Approvata dalla Regione"),
//    I("Richiesta integrazioni dalla Regione");
//
//    private final String value;
//
//    StatoRiparti(String value) {
//        this.value = value;
//    }
//
//    public String getValue() {
//        return value;
//    }
//}

