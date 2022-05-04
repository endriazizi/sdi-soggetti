package it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.enumeration.TipologiaSoggetto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
//@NoArgsConstructor
//@AllArgsConstructor
public class ResidenzaCreateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id;

	private String indirizzo;

	private String civico;

	private String cap;

	private Boolean aire;

	private Boolean separaDomicilioResidenza;

	private AnagraficaDTO anagrafica;

	private NazioneDTO nazione;

	private ComuneDTO comune;


}
