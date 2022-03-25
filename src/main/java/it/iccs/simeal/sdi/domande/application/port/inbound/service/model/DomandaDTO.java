package it.iccs.simeal.sdi.domande.application.port.inbound.service.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class DomandaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private UUID id;

	private Short flagElimina;

}