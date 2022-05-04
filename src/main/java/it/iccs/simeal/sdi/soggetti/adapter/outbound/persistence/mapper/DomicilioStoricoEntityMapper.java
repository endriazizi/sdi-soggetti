package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.DomicilioEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.DomicilioStoricoEntity;
import it.iccs.simeal.sdi.soggetti.application.model.DomicilioModel;
import it.iccs.simeal.sdi.soggetti.application.model.DomicilioStoricoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface DomicilioStoricoEntityMapper extends EntityMapper<DomicilioStoricoEntity, DomicilioStoricoModel> {

	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	DomicilioStoricoEntity fromModelToEntity(DomicilioStoricoModel model);

}
