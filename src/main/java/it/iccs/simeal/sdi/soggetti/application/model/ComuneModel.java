package it.iccs.simeal.sdi.soggetti.application.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class ComuneModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private UUID id;

	private String comune;

	private String provincia;

	private String cap;

	private String localita;

	private String belfiore;

	private String regione;

	private String codiceRegione;

	private String idNazione;

	private String istat;

	private Boolean flagProvincia;

}
