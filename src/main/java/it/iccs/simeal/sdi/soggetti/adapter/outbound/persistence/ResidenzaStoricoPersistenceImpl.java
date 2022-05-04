package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.mapper.ResidenzaEntityMapper;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.mapper.ResidenzaStoricoEntityMapper;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.AnagraficaRepository;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.ResidenzaRepository;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.ResidenzaStoricoRepository;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.AnagraficaEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.ResidenzaEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.ResidenzaStoricoEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.specification.ResidenzaSpecification;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.specification.ResidenzaStoricoSpecification;
import it.iccs.simeal.sdi.soggetti.application.model.ResidenzaModel;
import it.iccs.simeal.sdi.soggetti.application.model.ResidenzaStoricoModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.ResidenzaCriteria;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.ResidenzaStoricoCriteria;
import it.iccs.simeal.sdi.soggetti.application.port.outbound.persistence.ResidenzaPersistence;
import it.iccs.simeal.sdi.soggetti.application.port.outbound.persistence.ResidenzaStoricoPersistence;
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
public class ResidenzaStoricoPersistenceImpl extends ResidenzaStoricoSpecification implements ResidenzaStoricoPersistence {
	
	private final Logger log = LoggerFactory.getLogger(ResidenzaStoricoPersistenceImpl.class);
	
//	@Autowired
//	private ResidenzaRepository residenzaRepository;

	@Autowired
	private ResidenzaStoricoRepository residenzaStoricoRepository;

	@Autowired
	private AnagraficaRepository anagraficaRepository;
	


	@Autowired
	private ResidenzaStoricoEntityMapper residenzaStoricoEntityMapper;

	@Override
	public ResidenzaStoricoModel save(ResidenzaStoricoModel residenzaStoricoModel) {
		log.debug("Request to save Residenza Storico: {}", residenzaStoricoModel);
        ResidenzaStoricoEntity entityToSave = this.residenzaStoricoEntityMapper.fromModelToEntity(residenzaStoricoModel);

		if (residenzaStoricoModel.getAnagrafica() != null && residenzaStoricoModel.getAnagrafica().getId() != null) {
			AnagraficaEntity anagraficaEntity = anagraficaRepository.findById(residenzaStoricoModel.getAnagrafica().getId())
					.stream()
					.findAny()
					.orElse(null);
			entityToSave.setAnagrafica(anagraficaEntity);
		}
		ResidenzaStoricoEntity savedEntity = residenzaStoricoRepository.save(entityToSave);
        return this.residenzaStoricoEntityMapper.fromEntityToModel(savedEntity);
	}

	@Override
	public List<ResidenzaStoricoModel> findByIds(List<UUID> ids) {
		log.debug("Request to find any Residenza Storico: {}", ids);
        List<ResidenzaStoricoEntity> entities = residenzaStoricoRepository.findAllById(ids);
        return residenzaStoricoEntityMapper.fromEntitiesToModels(entities);
	}

	@Override
	public Page<ResidenzaStoricoModel> search(ResidenzaStoricoCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search Residenza Storico: {}", criteria);
        Page<ResidenzaStoricoEntity> entities = residenzaStoricoRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.residenzaStoricoEntityMapper.fromEntityToModel(entity));
    }



	@Override
	public void delete(UUID id) {
        log.debug("Request to delete Residenza Storico: {}", id);
		residenzaStoricoRepository.deleteById(id);
	}

}
