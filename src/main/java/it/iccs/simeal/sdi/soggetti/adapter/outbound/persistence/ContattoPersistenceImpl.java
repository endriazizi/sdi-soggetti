package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.mapper.ContattoEntityMapper;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.mapper.ResidenzaEntityMapper;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.AnagraficaRepository;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.ContattoRepository;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.ResidenzaRepository;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.AnagraficaEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.ContattoEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.ResidenzaEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.specification.ContattoSpecification;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.specification.ResidenzaSpecification;
import it.iccs.simeal.sdi.soggetti.application.model.ContattoModel;
import it.iccs.simeal.sdi.soggetti.application.model.ResidenzaModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.ContattoCriteria;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.ResidenzaCriteria;
import it.iccs.simeal.sdi.soggetti.application.port.outbound.persistence.ContattoPersistence;
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
public class ContattoPersistenceImpl extends ContattoSpecification implements ContattoPersistence {
	
	private final Logger log = LoggerFactory.getLogger(ContattoPersistenceImpl.class);

	@Autowired
	private ContattoRepository contattoRepository;

	@Autowired
	private AnagraficaRepository anagraficaRepository;
	


	@Autowired
	private ContattoEntityMapper contattoEntityMapper;

	@Override
	public ContattoModel save(ContattoModel contattoModel) {
		log.debug("Request to save Contatto: {}", contattoModel);
        ContattoEntity entityToSave = this.contattoEntityMapper.fromModelToEntity(contattoModel);

		if (contattoModel.getAnagrafica() != null && contattoModel.getAnagrafica().getId() != null) {
			AnagraficaEntity anagraficaEntity = anagraficaRepository.findById(contattoModel.getAnagrafica().getId())
					.stream()
					.findAny()
					.orElse(null);
			entityToSave.setAnagrafica(anagraficaEntity);
		}
		ContattoEntity savedEntity = contattoRepository.save(entityToSave);
        return this.contattoEntityMapper.fromEntityToModel(savedEntity);
	}

	@Override
	public List<ContattoModel> findByIds(List<UUID> ids) {
		log.debug("Request to find any Contatto: {}", ids);
        List<ContattoEntity> entities = contattoRepository.findAllById(ids);
        return contattoEntityMapper.fromEntitiesToModels(entities);
	}

	@Override
	public Page<ContattoModel> search(ContattoCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search Contatto: {}", criteria);
        Page<ContattoEntity> entities = contattoRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.contattoEntityMapper.fromEntityToModel(entity));
    }



	@Override
	public void delete(UUID id) {
        log.debug("Request to delete Contatto: {}", id);
		contattoRepository.deleteById(id);
	}

}
