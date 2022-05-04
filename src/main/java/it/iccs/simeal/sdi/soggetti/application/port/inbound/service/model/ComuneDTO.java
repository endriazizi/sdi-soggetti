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
public class ComuneDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private UUID id;

	private Short comune;

	private String provincia;

	private String cap;

	private String localita;

	private String belfiore;

	private String regione;

	private String codiceRegione;

	private String idNazione;

	private String istat;

	private Boolean flagProvincia;

	private Short flagElimina;

}
