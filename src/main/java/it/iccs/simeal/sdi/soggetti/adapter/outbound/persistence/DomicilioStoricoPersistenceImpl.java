package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.mapper.DomicilioStoricoEntityMapper;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.AnagraficaRepository;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.DomicilioStoricoRepository;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.AnagraficaEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.DomicilioStoricoEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.specification.DomcicilioStoricoSpecification;
import it.iccs.simeal.sdi.soggetti.application.model.DomicilioStoricoModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomicilioStoricoCriteria;
import it.iccs.simeal.sdi.soggetti.application.port.outbound.persistence.DomicilioStoricoPersistence;
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
public class DomicilioStoricoPersistenceImpl extends DomcicilioStoricoSpecification implements DomicilioStoricoPersistence {
	
	private final Logger log = LoggerFactory.getLogger(DomicilioStoricoPersistenceImpl.class);
	
//	@Autowired
//	private ResidenzaRepository residenzaRepository;

	@Autowired
	private DomicilioStoricoRepository domicilioStoricoRepository;

	@Autowired
	private AnagraficaRepository anagraficaRepository;

	@Autowired
	private DomicilioStoricoEntityMapper domicilioStoricoEntityMapper;

	@Override
	public DomicilioStoricoModel save(DomicilioStoricoModel domicilioStoricoModel) {
		log.debug("Request to save Domicilio Storico: {}", domicilioStoricoModel);
        DomicilioStoricoEntity entityToSave = this.domicilioStoricoEntityMapper.fromModelToEntity(domicilioStoricoModel);

		if (domicilioStoricoModel.getAnagrafica() != null && domicilioStoricoModel.getAnagrafica().getId() != null) {
			AnagraficaEntity anagraficaEntity = anagraficaRepository.findById(domicilioStoricoModel.getAnagrafica().getId())
					.stream()
					.findAny()
					.orElse(null);
			entityToSave.setAnagrafica(anagraficaEntity);
		}
		DomicilioStoricoEntity savedEntity = domicilioStoricoRepository.save(entityToSave);
        return this.domicilioStoricoEntityMapper.fromEntityToModel(savedEntity);
	}

	@Override
	public List<DomicilioStoricoModel> findByIds(List<UUID> ids) {
		log.debug("Request to find any Domicilio Storico: {}", ids);
        List<DomicilioStoricoEntity> entities = domicilioStoricoRepository.findAllById(ids);
        return domicilioStoricoEntityMapper.fromEntitiesToModels(entities);
	}

	@Override
	public Page<DomicilioStoricoModel> search(DomicilioStoricoCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search Domicilio Storico: {}", criteria);
        Page<DomicilioStoricoEntity> entities = domicilioStoricoRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.domicilioStoricoEntityMapper.fromEntityToModel(entity));
    }



	@Override
	public void delete(UUID id) {
        log.debug("Request to delete Domicilio Storico: {}", id);
		domicilioStoricoRepository.deleteById(id);
	}

}
