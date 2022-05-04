package it.iccs.simeal.sdi.soggetti.application.mapper;

import it.iccs.simeal.sdi.soggetti.application.model.DomicilioModel;
import it.iccs.simeal.sdi.soggetti.application.model.DomicilioStoricoModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.*;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {})
public interface DomicilioStoricoModelMapper extends ModelMapper<DomicilioStoricoDTO, DomicilioStoricoModel> {
	
	default DomicilioStoricoModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new DomicilioStoricoModel().setId(id);
	}

	DomicilioStoricoDTO fromCreateDto(DomicilioStoricoCreateDTO dto);

	DomicilioStoricoDTO fromUpdateDto(DomicilioStoricoUpdateDTO dto);
	
}
