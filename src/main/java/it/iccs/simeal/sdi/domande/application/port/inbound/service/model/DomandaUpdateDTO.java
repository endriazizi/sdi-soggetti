package it.iccs.simeal.sdi.domande.application.port.inbound.service.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
@NoArgsConstructor
public class DomandaUpdateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private UUID id;
}
