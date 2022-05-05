package it.iccs.simeal.sdi.soggetti.application.mapper;

import it.iccs.simeal.sdi.soggetti.application.model.ContattoModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.*;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {})
public interface ContattoModelMapper extends ModelMapper<ContattoDTO, ContattoModel> {
	
	default ContattoModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new ContattoModel().setId(id);
	}

	ContattoDTO fromCreateDto(ContattoCreateDTO dto);

	ContattoDTO fromUpdateDto(ContattoUpdateDTO dto);
	
}
