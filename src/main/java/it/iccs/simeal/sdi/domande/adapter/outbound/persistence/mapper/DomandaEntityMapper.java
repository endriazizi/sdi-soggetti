package it.iccs.simeal.sdi.domande.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.domande.adapter.outbound.persistence.repository.entity.DomandaEntity;
import it.iccs.simeal.sdi.domande.application.model.DomandaModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface DomandaEntityMapper extends EntityMapper<DomandaEntity, DomandaModel> {

	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	DomandaEntity fromModelToEntity(DomandaModel model);

}
