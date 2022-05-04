package it.iccs.simeal.sdi.soggetti.application.port.inbound.service;

import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DomicilioService {
	
	DomicilioDTO create(DomicilioCreateDTO dto);

	List<DomicilioDTO> findByIds(List<UUID> ids);

	Page<DomicilioDTO> search(DomicilioCriteria criteria, Pageable pageRequest);

	DomicilioDTO update(DomicilioUpdateDTO dto);

	void delete(UUID id);
	
}
