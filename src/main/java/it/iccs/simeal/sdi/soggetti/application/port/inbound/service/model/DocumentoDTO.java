package it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.enumeration.EnteRilascio;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.enumeration.TipologiaDocumento;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class DocumentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id;

	private TipologiaDocumento tipologiaDocumento;

	private String numero;

	private EnteRilascio enteRilascio;

	private LocalDate dataRilascio;

	private AnagraficaDTO anagrafica;

	private ComuneDTO comune;

	private Short flagElimina;
}
