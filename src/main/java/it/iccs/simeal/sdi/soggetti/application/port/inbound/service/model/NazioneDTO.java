package it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class NazioneDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private UUID id;

	private String nazione;

	private String sigla;

	private String belfiore;

	private String nazionalita;

	private String sigla3;

	private String iso3166;

	private String iso3166_alpha2;

	private String iso3166_alpha3;

	private Short flagElimina;

}
