package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.ContattoEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.ResidenzaEntity;
import it.iccs.simeal.sdi.soggetti.application.model.ContattoModel;
import it.iccs.simeal.sdi.soggetti.application.model.ResidenzaModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ContattoEntityMapper extends EntityMapper<ContattoEntity, ContattoModel> {

	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	ContattoEntity fromModelToEntity(ContattoModel model);

}
