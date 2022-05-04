package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.enumeration.TipologiaSoggetto;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "sdi_anagrafica")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Accessors(chain = true)
public class AnagraficaEntity implements Serializable {
    //public class AnagraficaEntity  extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

//    @Column(name = "tipologia_soggetto", nullable = false)
//    private String tipologiaSoggetto;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipologia_soggetto", nullable = false)
    private TipologiaSoggetto tipologiaSoggetto;

    @Column(name = "denominazione" )
    private String denominazione;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    @Column(name = "localita_nascita")
    private String localitaNascita;

    @Column(name = "provincia_nascita")
    private String provinciaNascita;

    @Column(name = "codice_fiscale")
    private String codiceFiscale;

    @Column(name = "sesso")
    private String sesso;

    @Column(name = "note")
    private String note;

    @Column(name = "flag_elimina")
    private Short flagElimina;
}
