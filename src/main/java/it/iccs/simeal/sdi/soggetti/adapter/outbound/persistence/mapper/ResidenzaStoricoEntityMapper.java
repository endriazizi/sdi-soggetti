package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.ResidenzaEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.ResidenzaStoricoEntity;
import it.iccs.simeal.sdi.soggetti.application.model.ResidenzaModel;
import it.iccs.simeal.sdi.soggetti.application.model.ResidenzaStoricoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ResidenzaStoricoEntityMapper extends EntityMapper<ResidenzaStoricoEntity, ResidenzaStoricoModel> {

	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	ResidenzaStoricoEntity fromModelToEntity(ResidenzaStoricoModel model);

}
