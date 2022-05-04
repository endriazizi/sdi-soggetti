package it.iccs.simeal.sdi.soggetti.application.mapper;

import it.iccs.simeal.sdi.soggetti.application.model.ResidenzaModel;
import it.iccs.simeal.sdi.soggetti.application.model.ResidenzaStoricoModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.*;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {})
public interface ResidenzaStoricoModelMapper extends ModelMapper<ResidenzaStoricoDTO, ResidenzaStoricoModel> {
	
	default ResidenzaStoricoModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new ResidenzaStoricoModel().setId(id);
	}

	ResidenzaStoricoDTO fromCreateDto(ResidenzaStoricoCreateDTO dto);

	ResidenzaStoricoDTO fromUpdateDto(ResidenzaStoricoUpdateDTO dto);
	
}
