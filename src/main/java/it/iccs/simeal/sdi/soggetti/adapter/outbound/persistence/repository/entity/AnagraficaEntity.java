package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class AnagraficaEntity  extends AbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "tipologia_soggetto", nullable = false)
    private String tipologiaSoggetto;

    @Column(name = "denominazione", nullable = false)
    private String denominazione;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "data_nascita", nullable = false)
    private LocalDate dataNascita;

    @Column(name = "localita_nascita", nullable = false)
    private String localitaNascita;

    @Column(name = "provincia_nascita", nullable = false)
    private String provinciaNascita;

    @Column(name = "codice_fiscale", nullable = false)
    private String codiceFiscale;

    @Column(name = "sesso", nullable = false)
    private String sesso;

    @Column(name = "note", nullable = false)
    private String note;
}
