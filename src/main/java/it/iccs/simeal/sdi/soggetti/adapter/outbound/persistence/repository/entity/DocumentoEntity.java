package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.enumeration.EnteRilascio;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.enumeration.TipologiaDocumento;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "sdi_documento")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Accessors(chain = true)
public class DocumentoEntity implements Serializable {
    //public class AnagraficaEntity  extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "tipologia_documento" )
    private TipologiaDocumento tipologiaDocumento;

    @Column(name = "numero")
    private String numero;

    @Column(name = "pec")
    private String pec;

    @Column(name = "ente_rilascio")
    private EnteRilascio enteRilascio;

    @Column(name = "aire")
    private Boolean aire;

    @Column(name = "data_rilascio")
    private LocalDate dataRilascio;

    @Column(name = "flag_elimina")
    private Short flagElimina;

    /**
     **** RELAZIONI ***
     */
    @JoinColumn(name = "id_anagrafica", referencedColumnName = "id", nullable = false)
    @ManyToOne(cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private AnagraficaEntity anagrafica;

    @JoinColumn(name = "id_comune", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private ComuneEntity comune;
}
