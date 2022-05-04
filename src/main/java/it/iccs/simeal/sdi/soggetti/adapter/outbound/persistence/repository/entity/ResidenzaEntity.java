package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.enumeration.TipologiaSoggetto;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "sdi_residenza")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Accessors(chain = true)
public class ResidenzaEntity implements Serializable {
    //public class AnagraficaEntity  extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "denominazione" )
    private String denominazione;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "civico")
    private String civico;

    @Column(name = "cap")
    private String cap;

    @Column(name = "aire")
    private Boolean aire;

    @Column(name = "separa_domicilio_residenza")
    private String separaDomicilioResidenza;

    @Column(name = "sesso")
    private String sesso;

    @Column(name = "flag_elimina")
    private Short flagElimina;

    /**
     **** RELAZIONI ***
     */
    @JoinColumn(name = "id_anagrafica", referencedColumnName = "id", nullable = false)
    @ManyToOne(cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private AnagraficaEntity anagrafica;

    @JoinColumn(name = "id_nazione", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private NazioneEntity nazione;

    @JoinColumn(name = "id_comune", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    private ComuneEntity comune;
}
