package it.iccs.simeal.sdi.soggetti.application.port.inbound.service;

import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ResidenzaService {
	
	ResidenzaDTO create(ResidenzaCreateDTO dto);

	List<ResidenzaDTO> findByIds(List<UUID> ids);

	Page<ResidenzaDTO> search(ResidenzaCriteria criteria, Pageable pageRequest);

	ResidenzaDTO update(ResidenzaUpdateDTO dto);

	void delete(UUID id);
	
}
