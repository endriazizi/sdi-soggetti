package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity;


import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

/**
 * Base abstract class for entities which will hold definitions for created, last modified, created by,
 * last modified by attributes.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @CreatedBy
    @Column(name = "utente_creazione", nullable = false, length = 30, updatable = false)
    private String utenteCreazione;

    @CreatedDate
    @Column(name = "data_creazione", updatable = false)
    private Instant dataCreazione;

    @LastModifiedBy
    @Column(name = "utente_ultima_modifica", length = 30)
    private String utenteUltimaModifica;

    @LastModifiedDate
    @Column(name = "data_ultima_modifica")
    private Instant dataUltimaModifica;

    @Version
    @Column(name = "version")
    private Integer version;

}
