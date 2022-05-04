package it.iccs.simeal.sdi.soggetti.application.mapper;

import it.iccs.simeal.sdi.soggetti.application.model.AnagraficaModel;
import it.iccs.simeal.sdi.soggetti.application.model.ResidenzaModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.*;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {})
public interface ResidenzaModelMapper extends ModelMapper<ResidenzaDTO, ResidenzaModel> {
	
	default ResidenzaModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new ResidenzaModel().setId(id);
	}
	
	ResidenzaDTO fromCreateDto(ResidenzaCreateDTO dto);

	ResidenzaDTO fromUpdateDto(ResidenzaUpdateDTO dto);
	
}
