package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.AnagraficaEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.ResidenzaEntity;
import it.iccs.simeal.sdi.soggetti.application.model.AnagraficaModel;
import it.iccs.simeal.sdi.soggetti.application.model.ResidenzaModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ResidenzaEntityMapper extends EntityMapper<ResidenzaEntity, ResidenzaModel> {

	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	ResidenzaEntity fromModelToEntity(ResidenzaModel model);

}
