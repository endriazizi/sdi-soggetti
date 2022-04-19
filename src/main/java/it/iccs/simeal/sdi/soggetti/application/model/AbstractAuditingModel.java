package it.iccs.simeal.sdi.soggetti.application.model;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public abstract class AbstractAuditingModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String utenteCreazione;

    private Instant dataCreazione;

    private Instant dataUltimaModifica;

    private String utenteUltimaModifica;

    private Integer version;
}

