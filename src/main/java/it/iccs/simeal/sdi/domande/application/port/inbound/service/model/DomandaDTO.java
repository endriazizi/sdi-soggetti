package it.iccs.simeal.sdi.domande.application.port.inbound.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.awt.*;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class DomandaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private UUID id;

	@NotNull
	private Short idTipologiaDomanda;

	@NotNull
	private UUID idRichiedente1;

	private UUID idRichiedente2;

	@NotNull
	private UUID idBeneficiario;

	private UUID idAvviso;

	@NotNull
	private Integer anno;

	private UUID idIstituto;

	private UUID idClasse;

	private UUID idSezione;

	private UUID idStatoDomanda;

	private LocalDate dataCreazione;

	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime oraCreazione;

	private LocalDate dataInvio;

	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime OraInvio;

	private Short idTipologiaInvio;

	private String numeroProtocollo;

	private LocalDate dataProtocollo;

	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime oraProtocollo;

	private String segnaturaProtocollo;

	private String note;

	private Short flagElimina;

}
