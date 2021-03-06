package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.mapper.DomicilioEntityMapper;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.AnagraficaRepository;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.DomicilioRepository;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.AnagraficaEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.DomicilioEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.specification.DomcilioSpecification;
import it.iccs.simeal.sdi.soggetti.application.model.DomicilioModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomicilioCriteria;
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
public class DomicilioPersistenceImpl extends DomcilioSpecification implements DomicilioPersistence {
	
	private final Logger log = LoggerFactory.getLogger(DomicilioPersistenceImpl.class);
	
//	@Autowired
//	private ResidenzaRepository residenzaRepository;

	@Autowired
	private DomicilioRepository domicilioRepository;

	@Autowired
	private AnagraficaRepository anagraficaRepository;

	@Autowired
	private DomicilioEntityMapper domicilioEntityMapper;

	@Override
	public DomicilioModel save(DomicilioModel domicilioModel) {
		log.debug("Request to save Domicilio: {}", domicilioModel);
        DomicilioEntity entityToSave = this.domicilioEntityMapper.fromModelToEntity(domicilioModel);

		if (domicilioModel.getAnagrafica() != null && domicilioModel.getAnagrafica().getId() != null) {
			AnagraficaEntity anagraficaEntity = anagraficaRepository.findById(domicilioModel.getAnagrafica().getId())
					.stream()
					.findAny()
					.orElse(null);
			entityToSave.setAnagrafica(anagraficaEntity);
		}
		DomicilioEntity savedEntity = domicilioRepository.save(entityToSave);
        return this.domicilioEntityMapper.fromEntityToModel(savedEntity);
	}

	@Override
	public List<DomicilioModel> findByIds(List<UUID> ids) {
		log.debug("Request to find any Domicilio {}", ids);
        List<DomicilioEntity> entities = domicilioRepository.findAllById(ids);
        return domicilioEntityMapper.fromEntitiesToModels(entities);
	}

	@Override
	public Page<DomicilioModel> search(DomicilioCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search Domicilio: {}", criteria);
        Page<DomicilioEntity> entities = domicilioRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.domicilioEntityMapper.fromEntityToModel(entity));
    }



	@Override
	public void delete(UUID id) {
        log.debug("Request to delete Domicilio {}", id);
		domicilioRepository.deleteById(id);
	}

}
