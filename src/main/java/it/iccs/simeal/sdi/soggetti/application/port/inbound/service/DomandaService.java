package it.iccs.simeal.sdi.soggetti.application.port.inbound.service;

import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomandaCreateDTO;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomandaCriteria;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomandaDTO;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomandaUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DomandaService {
	
	DomandaDTO create(DomandaCreateDTO dto);
	
	List<DomandaDTO> findByIds(List<UUID> ids);
	
	Page<DomandaDTO> search(DomandaCriteria criteria, Pageable pageRequest);
	
	DomandaDTO update(DomandaUpdateDTO dto);
	
	void delete(UUID id);
	
}
