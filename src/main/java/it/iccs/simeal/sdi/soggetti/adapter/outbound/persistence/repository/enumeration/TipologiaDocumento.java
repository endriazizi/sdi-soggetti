package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.enumeration;

public enum TipologiaDocumento {
    PERMESSO_DI_SOGGIORNO_ESTERO_SUPERIORE_AD_UN_ANNO("Permesso di soggiorno estero superiore ad un anno"),
    PERMESSO_CE_LUNGO_PERIODO("Permesso CE lungo periodo"),
    CARTA_DI_IDENTITA("Carta d'identità");

    private final String value;

    TipologiaDocumento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

//        INSERT INTO `sso_tabella_condizione_soggiorno` (`idsso_tabella_condizione_soggiorno`, `descrizione`, `codice`, `codice_inps`, `condizione_ordine`) VALUES
//        (1, 'Permesso di soggiorno estero superiore ad un anno', '1590', 'PDS', 10),
//        (2, 'Permesso CE lungo periodo', '1600', NULL, 10),
//        (3, 'Titolo di viaggio per apolidi', NULL, NULL, 0),
//        (4, 'Ricevuta di attesa rilascio o rinnovo P.S.', NULL, NULL, 0),
//        (5, 'Titolo di viaggio con visto', NULL, NULL, 0),
//        (6, 'Permesso per protezione internazionale', '1570', NULL, 10),
//        (7, 'Permesso di soggiorno estero inferiore ad un anno', '1580', 'PDS', 10),
//        (8, 'Altro documento di soggiorno estero', '1610', 'PDS', 10),
//        (9, 'Carta d\'identitÃ ', NULL, 'CIP', 1),
//        (10, 'Carta Identita\' Estera', NULL, 'CIE', 2),
//        (12, 'Doc.Ric.Ambasciate e Consolati Italiani', NULL, 'DAC', 4),
//        (13, 'Libretto Ciechi ed Invalidi', NULL, 'LCI', 5),
//        (14, 'Lib. Nominativo per Minorati Civili Mod. 4', NULL, 'LNM', 6),
//        (15, 'Lib. Pensioni INPS', NULL, 'LPI', 7),
//        (16, 'Patente di Guida', NULL, 'PAP', 8),
//        (17, 'Porto d\'Armi', NULL, 'PDP', 9),
//        (18, 'Passaporto Estero', NULL, 'PSE', 11),
//        (19, 'Passaporto', NULL, 'PSP', 12),
//        (20, 'Tess. Dip. Statali Civili Militari', NULL, 'TSM', 13);




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

