package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.mapper.ResidenzaEntityMapper;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.AnagraficaRepository;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.ResidenzaRepository;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.AnagraficaEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.ResidenzaEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.specification.ResidenzaSpecification;
import it.iccs.simeal.sdi.soggetti.application.model.ResidenzaModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.AnagraficaCriteria;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.ResidenzaCriteria;
import it.iccs.simeal.sdi.soggetti.application.port.outbound.persistence.ResidenzaPersistence;
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
public class ResidenzaPersistenceImpl extends ResidenzaSpecification implements ResidenzaPersistence {
	
	private final Logger log = LoggerFactory.getLogger(ResidenzaPersistenceImpl.class);
	
//	@Autowired
//	private ResidenzaRepository residenzaRepository;

	@Autowired
	private ResidenzaRepository residenzaRepository;

	@Autowired
	private AnagraficaRepository anagraficaRepository;
	


	@Autowired
	private ResidenzaEntityMapper residenzaEntityMapper;

	@Override
	public ResidenzaModel save(ResidenzaModel residenzaModel) {
		log.debug("Request to save Residenza: {}", residenzaModel);
        ResidenzaEntity entityToSave = this.residenzaEntityMapper.fromModelToEntity(residenzaModel);

		if (residenzaModel.getAnagrafica() != null && residenzaModel.getAnagrafica().getId() != null) {
			AnagraficaEntity anagraficaEntity = anagraficaRepository.findById(residenzaModel.getAnagrafica().getId())
					.stream()
					.findAny()
					.orElse(null);
			entityToSave.setAnagrafica(anagraficaEntity);
		}
		ResidenzaEntity savedEntity = residenzaRepository.save(entityToSave);
        return this.residenzaEntityMapper.fromEntityToModel(savedEntity);
	}

	@Override
	public List<ResidenzaModel> findByIds(List<UUID> ids) {
		log.debug("Request to find any Residenza {}", ids);
        List<ResidenzaEntity> entities = residenzaRepository.findAllById(ids);
        return residenzaEntityMapper.fromEntitiesToModels(entities);
	}

	@Override
	public Page<ResidenzaModel> search(ResidenzaCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search Residenza: {}", criteria);
        Page<ResidenzaEntity> entities = residenzaRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.residenzaEntityMapper.fromEntityToModel(entity));
    }



	@Override
	public void delete(UUID id) {
        log.debug("Request to delete Residenza {}", id);
        residenzaRepository.deleteById(id);
	}

}
