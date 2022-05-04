package it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.enumeration.TipologiaSoggetto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
@NoArgsConstructor
public class ResidenzaUpdateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id;

	private String denominazione;

	private String cognome;

	private String nome;

	private LocalDate dataNascita;

	private String localitaNascita;

	private String provinciaNascita;

	private String codiceFiscale;

	private String sesso;

	private String note;

}
