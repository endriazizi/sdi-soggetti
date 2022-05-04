package it.iccs.simeal.sdi.soggetti.application.port.inbound.service;

import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DomicilioStoricoService {

	DomicilioStoricoDTO create(DomicilioStoricoCreateDTO dto);

	List<DomicilioStoricoDTO> findByIds(List<UUID> ids);

	Page<DomicilioStoricoDTO> search(DomicilioStoricoCriteria criteria, Pageable pageRequest);

	DomicilioStoricoDTO update(DomicilioStoricoUpdateDTO dto);

	void delete(UUID id);
	
}
