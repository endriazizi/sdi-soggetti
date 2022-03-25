package it.iccs.simeal.sdi.domande.application.port.inbound.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DomandaCreateDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer anno;
	
	private String descrizione;
	
	private Short annoCorrente;
	
	private Short flagCongelaAnno;
	
	private Short flagIseeCalcolo;

}
