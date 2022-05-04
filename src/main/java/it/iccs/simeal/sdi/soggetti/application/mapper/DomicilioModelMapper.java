package it.iccs.simeal.sdi.soggetti.application.mapper;

import it.iccs.simeal.sdi.soggetti.application.model.DomicilioModel;
import it.iccs.simeal.sdi.soggetti.application.model.ResidenzaModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.*;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {})
public interface DomicilioModelMapper extends ModelMapper<DomicilioDTO, DomicilioModel> {
	
	default DomicilioModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new DomicilioModel().setId(id);
	}

	DomicilioDTO fromCreateDto(DomicilioCreateDTO dto);

	DomicilioDTO fromUpdateDto(DomicilioUpdateDTO dto);
	
}
