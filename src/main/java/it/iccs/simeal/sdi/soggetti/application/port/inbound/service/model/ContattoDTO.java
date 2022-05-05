package it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class ContattoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private UUID id;

	private String email;

	private String pec;

	private String telefono;

	private String cellulare;

	private Short flagElimina;

	private AnagraficaDTO anagrafica;
}
