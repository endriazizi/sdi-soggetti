package it.iccs.simeal.sdi.soggetti.application.mapper;

import it.iccs.simeal.sdi.soggetti.application.model.DocumentoModel;
import it.iccs.simeal.sdi.soggetti.application.model.ResidenzaModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.*;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {})
public interface DocumentoModelMapper extends ModelMapper<DocumentoDTO, DocumentoModel> {
	
	default DocumentoDTO fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new DocumentoDTO().setId(id);
	}
	
	DocumentoDTO fromCreateDto(DocumentoCreateDTO dto);

	DocumentoDTO fromUpdateDto(DocumentoUpdateDTO dto);
	
}
