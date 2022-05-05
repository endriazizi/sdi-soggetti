package it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model;

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
public class ContattoUpdateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id;

	private String email;

	private String pec;

	private String telefono;

	private String cellulare;

	private AnagraficaDTO anagrafica;

	private ComuneDTO comune;
}
