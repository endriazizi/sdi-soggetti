package it.iccs.simeal.sdi.soggetti.application.mapper;

import it.iccs.simeal.sdi.soggetti.application.model.AnagraficaModel;
import it.iccs.simeal.sdi.soggetti.application.model.DomandaModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.*;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {})
public interface AnagraficaModelMapper extends ModelMapper<AnagraficaDTO, AnagraficaModel> {
	
	default AnagraficaModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new AnagraficaModel().setId(id);
	}
	
	AnagraficaDTO fromCreateDto(AnagraficaCreateDTO dto);

	AnagraficaDTO fromUpdateDto(AnagraficaUpdateDTO dto);
	
}
