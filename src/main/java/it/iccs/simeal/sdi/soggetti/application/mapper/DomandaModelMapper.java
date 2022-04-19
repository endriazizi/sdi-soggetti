package it.iccs.simeal.sdi.soggetti.application.mapper;

import it.iccs.simeal.sdi.soggetti.application.model.DomandaModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomandaCreateDTO;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomandaDTO;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomandaUpdateDTO;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {})
public interface DomandaModelMapper extends ModelMapper<DomandaDTO, DomandaModel> {
	
	default DomandaModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new DomandaModel().setId(id);
	}
	
	DomandaDTO fromCreateDto(DomandaCreateDTO dto);

	DomandaDTO fromUpdateDto(DomandaUpdateDTO dto);
	
}
