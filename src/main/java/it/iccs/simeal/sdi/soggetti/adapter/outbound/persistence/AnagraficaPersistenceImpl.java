package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.mapper.AnagraficaEntityMapper;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.AnagraficaRepository;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.DomandaRepository;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.AnagraficaEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.specification.AnagraficaSpecification;
import it.iccs.simeal.sdi.soggetti.application.model.AnagraficaModel;
import it.iccs.simeal.sdi.soggetti.application.model.DomandaModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.AnagraficaCriteria;
import it.iccs.simeal.sdi.soggetti.application.port.outbound.persistence.AnagraficaPersistence;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class AnagraficaPersistenceImpl extends AnagraficaSpecification implements AnagraficaPersistence {
	
	private final Logger log = LoggerFactory.getLogger(AnagraficaPersistenceImpl.class);
	
	@Autowired
	private DomandaRepository domandaRepository;

	@Autowired
	private AnagraficaRepository anagraficaRepository;
	


	@Autowired
	private AnagraficaEntityMapper anagraficaEntityMapper;

	@Override
	public AnagraficaModel save(AnagraficaModel anagraficaModel) {
		log.debug("Request to save Anagrafica: {}", anagraficaModel);
        AnagraficaEntity entityToSave = this.anagraficaEntityMapper.fromModelToEntity(anagraficaModel);
		AnagraficaEntity savedEntity = anagraficaRepository.save(entityToSave);
        return this.anagraficaEntityMapper.fromEntityToModel(savedEntity);
	}

	@Override
	public List<AnagraficaModel> findByIds(List<UUID> ids) {
		log.debug("Request to find any Anagrafica {}", ids);
        List<AnagraficaEntity> entities = anagraficaRepository.findAllById(ids);
        return anagraficaEntityMapper.fromEntitiesToModels(entities);
	}

	@Override
	public Page<AnagraficaModel> search(AnagraficaCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search Anagrafica: {}", criteria);
        Page<AnagraficaEntity> entities = anagraficaRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.anagraficaEntityMapper.fromEntityToModel(entity));
    }



	@Override
	public void delete(UUID id) {
        log.debug("Request to delete Anagrafica {}", id);
        domandaRepository.deleteById(id);
	}

}
