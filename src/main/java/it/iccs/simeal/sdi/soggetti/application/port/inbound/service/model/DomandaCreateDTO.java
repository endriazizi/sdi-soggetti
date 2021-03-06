package it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
//@NoArgsConstructor
//@AllArgsConstructor
public class DomandaCreateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

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
	private LocalTime oraInvio;

	private Short idTipologiaInvio;

	private String numeroProtocollo;

	private LocalDate dataProtocollo;

	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime oraProtocollo;

	private String segnaturaProtocollo;

	private String note;
}
