package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.mapper.DomandaEntityMapper;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.DomandaRepository;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.DomandaEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.specification.DomandaSpecification;
import it.iccs.simeal.sdi.soggetti.application.model.DomandaModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomandaCriteria;
import it.iccs.simeal.sdi.soggetti.application.port.outbound.persistence.DomandaPersistence;
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
public class DomandaPersistenceImpl extends DomandaSpecification implements DomandaPersistence {
	
	private final Logger log = LoggerFactory.getLogger(DomandaPersistenceImpl.class);
	
	@Autowired
	private DomandaRepository domandaRepository;
	
	@Autowired
	private DomandaEntityMapper entityMapper;

	@Override
	public DomandaModel save(DomandaModel domandaModel) {
		log.debug("Request to save Domanda: {}", domandaModel);
        DomandaEntity entityToSave = this.entityMapper.fromModelToEntity(domandaModel);
		DomandaEntity savedEntity = domandaRepository.save(entityToSave);
        return this.entityMapper.fromEntityToModel(savedEntity);
	}

	@Override
	public List<DomandaModel> findByIds(List<UUID> ids) {
		log.debug("Request to find any Domanda {}", ids);
        List<DomandaEntity> entities = domandaRepository.findAllById(ids);
        return entityMapper.fromEntitiesToModels(entities);
	}

	@Override
	public Page<DomandaModel> search(DomandaCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search Domanda: {}", criteria);
        Page<DomandaEntity> entities = domandaRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

	@Override
	public void delete(UUID id) {
        log.debug("Request to delete Domanda {}", id);
        domandaRepository.deleteById(id);
	}

}
