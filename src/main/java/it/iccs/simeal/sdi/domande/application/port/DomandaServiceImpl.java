package it.iccs.simeal.sdi.domande.application.port;

import io.github.jhipster.service.filter.IntegerFilter;
import it.iccs.simeal.sdi.domande.application.mapper.DomandaModelMapper;
import it.iccs.simeal.sdi.domande.application.model.DomandaModel;
import it.iccs.simeal.sdi.domande.application.port.inbound.service.DomandaService;
import it.iccs.simeal.sdi.domande.application.port.inbound.service.model.DomandaCreateDTO;
import it.iccs.simeal.sdi.domande.application.port.inbound.service.model.DomandaUpdateDTO;
import it.iccs.simeal.sdi.domande.application.port.inbound.service.model.DomandaCriteria;
import it.iccs.simeal.sdi.domande.application.port.inbound.service.model.DomandaDTO;
import it.iccs.simeal.sdi.domande.application.port.outbound.persistence.DomandaPersistence;
import it.iccs.simeal.sdi.domande.web.rest.errors.BadRequestException;
import it.iccs.simeal.sdi.domande.web.rest.errors.ConstraintsViolateException;
import it.iccs.simeal.sdi.domande.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class DomandaServiceImpl implements DomandaService {

	@Autowired
	private DomandaModelMapper domandaModelMapper;
	
	@Autowired
	private DomandaPersistence domandaPersistence;
	
	@Override
	public DomandaDTO create(DomandaCreateDTO dto) {
		DomandaDTO annoDTO = domandaModelMapper.fromCreateDto(dto);
        DomandaModel annoModel = domandaModelMapper.toModel(annoDTO);
        DomandaModel model = domandaPersistence.save(annoModel);
        return domandaModelMapper.toDto(model);
	}

	@Override
	public List<DomandaDTO> findByIds(List<UUID> ids) {
		List<DomandaModel> models = domandaPersistence.findByIds(ids);
		return domandaModelMapper.toDto(models);
	}

	@Override
	public Page<DomandaDTO> search(DomandaCriteria criteria, Pageable pageRequest) {
		Page<DomandaModel> models = domandaPersistence.search(criteria, pageRequest);
		return models.map(model -> this.domandaModelMapper.toDto(model));
	}

	@Override
	public DomandaDTO update(DomandaUpdateDTO dto) {
		DomandaDTO domandaDTO = domandaModelMapper.fromUpdateDto(dto);
		this.checkDomandaExists(domandaDTO.getId());
        DomandaModel annoModel = domandaModelMapper.toModel(domandaDTO);
        domandaPersistence.save(annoModel);
        DomandaModel model = domandaPersistence.findByIds(Collections.singletonList(domandaDTO.getId()))
                .stream()
                .findAny()
                .orElse(null);
        return domandaModelMapper.toDto(model);
	}

	@Override
	public void delete(UUID id) {
		this.checkDomandaExists(id);
		DomandaDTO domandaDTO = this.findByIds(Collections.singletonList(id))
				.stream()
				.findAny()
				.orElse(null);
		domandaDTO.setFlagElimina((short)1);

		DomandaModel domandaModel = domandaModelMapper.toModel(domandaDTO);
		domandaPersistence.save(domandaModel);
	}
	
	private void checkDomandaExists(UUID id) {
		if (domandaPersistence.findByIds(Collections.singletonList(id)).isEmpty()) {
			log.warn("Domanda {} not found", id);
			throw new NotFoundException(String.format("Domanda %s non trovato", id));
		}
	}
}
