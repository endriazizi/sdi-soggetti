package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.AnagraficaEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.DomandaEntity;
import it.iccs.simeal.sdi.soggetti.application.model.AnagraficaModel;
import it.iccs.simeal.sdi.soggetti.application.model.DomandaModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface AnagraficaEntityMapper extends EntityMapper<AnagraficaEntity, AnagraficaModel> {

	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	AnagraficaEntity fromModelToEntity(AnagraficaModel model);

}
