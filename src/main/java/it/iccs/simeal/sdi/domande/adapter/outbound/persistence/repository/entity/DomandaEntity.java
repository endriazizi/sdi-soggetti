package it.iccs.simeal.sdi.domande.adapter.outbound.persistence.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.awt.*;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "sdi_dmn_domanda")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Accessors(chain = true)
public class DomandaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "id_tipologia_domanda", nullable = false)
    private Short idTipologiaDomanda;

    @Column(name = "id_richiedente1", nullable = false)
    private UUID idRichiedente1;

    @Column(name = "id_richiedente2")
    private UUID idRichiedente2;

    @Column(name = "id_beneficiario", nullable = false)
    private UUID idBeneficiario;

    @Column(name = "id_avviso")
    private UUID idAvviso;

    @Column(name = "anno", nullable = false)
    private Integer anno;

    @Column(name = "id_istituto")
    private UUID idIstituto;

    @Column(name = "id_classe")
    private UUID idClasse;

    @Column(name = "id_sezione")
    private UUID idSezione;

    @Column(name = "id_stato_domanda", nullable = false)
    private Short idStatoDomanda;

    @Column(name = "data_creazione")
    private LocalDate dataCreazione;

    @Column(name = "ora_creazione")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime oraCreazione;

    @Column(name = "data_invio")
    private LocalDate dataInvio;

    @Column(name = "ora_invio")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime OraInvio;

    @NotNull
    @Column(name = "id_tipologia_invio")
    private Short idTipologiaInvio;

    @Column(name = "numero_protocollo")
    private String numeroProtocollo;

    @Column(name = "data_protocollo")
    private LocalDate dataProtocollo;

    @Column(name = "ora_protocollo")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime oraProtocollo;

    @Column(name = "segnatura_protocollo")
    private String segnaturaProtocollo;

    @Column(name = "note")
    private String note;

    @Column(name = "flag_elimina")
    private Short flagElimina;
}
