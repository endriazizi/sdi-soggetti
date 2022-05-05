package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.mapper.DocumentoEntityMapper;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.mapper.DomicilioEntityMapper;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.AnagraficaRepository;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.DocumentoRepository;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.DomicilioRepository;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.AnagraficaEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.DocumentoEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.DomicilioEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.specification.DocumentoSpecification;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.specification.DomcicilioSpecification;
import it.iccs.simeal.sdi.soggetti.application.model.DocumentoModel;
import it.iccs.simeal.sdi.soggetti.application.model.DomicilioModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DocumentoCriteria;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomicilioCriteria;
import it.iccs.simeal.sdi.soggetti.application.port.outbound.persistence.DocumentoPersistence;
import it.iccs.simeal.sdi.soggetti.application.port.outbound.persistence.DomicilioPersistence;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DocumentoPersistenceImpl extends DocumentoSpecification implements DocumentoPersistence {
	
	private final Logger log = LoggerFactory.getLogger(DocumentoPersistenceImpl.class);
	
//	@Autowired
//	private ResidenzaRepository residenzaRepository;

	@Autowired
	private DocumentoRepository documentoRepository;

	@Autowired
	private AnagraficaRepository anagraficaRepository;

	@Autowired
	private DocumentoEntityMapper documentoEntityMapper;

	@Override
	public DocumentoModel save(DocumentoModel documentoModel) {
		log.debug("Request to save Documento: {}", documentoModel);
        DocumentoEntity entityToSave = this.documentoEntityMapper.fromModelToEntity(documentoModel);

		if (documentoModel.getAnagrafica() != null && documentoModel.getAnagrafica().getId() != null) {
			AnagraficaEntity anagraficaEntity = anagraficaRepository.findById(documentoModel.getAnagrafica().getId())
					.stream()
					.findAny()
					.orElse(null);
			entityToSave.setAnagrafica(anagraficaEntity);
		}
		DocumentoEntity savedEntity = documentoRepository.save(entityToSave);
        return this.documentoEntityMapper.fromEntityToModel(savedEntity);
	}

	@Override
	public List<DocumentoModel> findByIds(List<UUID> ids) {
		log.debug("Request to find any Documento {}", ids);
        List<DocumentoEntity> entities = documentoRepository.findAllById(ids);
        return documentoEntityMapper.fromEntitiesToModels(entities);
	}

	@Override
	public Page<DocumentoModel> search(DocumentoCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search Documento: {}", criteria);
        Page<DocumentoEntity> entities = documentoRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.documentoEntityMapper.fromEntityToModel(entity));
    }



	@Override
	public void delete(UUID id) {
        log.debug("Request to delete Documento: {}", id);
		documentoRepository.deleteById(id);
	}

}
