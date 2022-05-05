package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.enumeration;

public enum EnteRilascio {
    COMUNE("COMUNE"),
    AUTORITA("AUTORITA'"),
    AUTORITA_CARCERARIA("AUTORITA' CARCERARIA");

    private final String value;

    EnteRilascio(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
/*
sso_tbl_documento_ente

        COMUNE
        AUTORITA'
        AUTORITA' CARCERARIA
        AMBASCIATA
        CONSOLATO
        MINISTERO
        REPUBBLICA
        STATO
        GOVERNO
        DIP.TRASPORTI TERRESTRI (EX MOTORIZZAZIONE)
        INPS
        PREFETTURA
        QUESTURA
        POLIZIA
        POLIZIA PENITENZIARIA
        COMMISSARIATO
        UFFICIO
        ENTE
*/
