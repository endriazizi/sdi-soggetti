package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.DomicilioEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.ResidenzaEntity;
import it.iccs.simeal.sdi.soggetti.application.model.DomicilioModel;
import it.iccs.simeal.sdi.soggetti.application.model.ResidenzaModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface DomicilioEntityMapper extends EntityMapper<DomicilioEntity, DomicilioModel> {

	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	DomicilioEntity fromModelToEntity(DomicilioModel model);

}
