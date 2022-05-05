package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.DocumentoEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.DomicilioEntity;
import it.iccs.simeal.sdi.soggetti.application.model.DocumentoModel;
import it.iccs.simeal.sdi.soggetti.application.model.DomicilioModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface DocumentoEntityMapper extends EntityMapper<DocumentoEntity, DocumentoModel> {

	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	DocumentoEntity fromModelToEntity(DocumentoModel model);

}
