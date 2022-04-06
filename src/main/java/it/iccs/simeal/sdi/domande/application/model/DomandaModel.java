package it.iccs.simeal.sdi.domande.application.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class DomandaModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private UUID id;

	private Short idTipologiaDomanda;

	private UUID idRichiedente1;

	private UUID idRichiedente2;

	private UUID idBeneficiario;

	private UUID idAvviso;

	private Integer anno;

	private UUID idIstituto;

	private UUID idClasse;

	private UUID idSezione;

	private UUID idStatoDomanda;

	private LocalDate dataCreazione;

	private LocalTime oraCreazione;

	private LocalDate dataInvio;

	private LocalTime oraInvio;

	private Short idTipologiaInvio;

	private String numeroProtocollo;

	private LocalDate dataProtocollo;

	private LocalTime oraProtocollo;

	private String segnaturaProtocollo;

	private String note;

	private Short flagElimina;
	
}
