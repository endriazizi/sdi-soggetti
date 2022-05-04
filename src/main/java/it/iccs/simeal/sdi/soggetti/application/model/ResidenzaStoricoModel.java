package it.iccs.simeal.sdi.soggetti.application.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class ResidenzaStoricoModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private UUID id;

	private String indirizzo;

	private String civico;

	private String cap;

	private Boolean aire;

	private Boolean separaDomicilioResidenza;

	private Short flagElimina;

	private AnagraficaModel anagrafica;

	private DomandaModel nazione;

	private ComuneModel comune;

}
