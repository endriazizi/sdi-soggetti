package it.iccs.simeal.sdi.soggetti.application.port.inbound.service;

import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface AnagraficaService {
	
	AnagraficaDTO create(AnagraficaCreateDTO dto);

	List<AnagraficaDTO> findByIds(List<UUID> ids);

	Page<AnagraficaDTO> search(AnagraficaCriteria criteria, Pageable pageRequest);

	AnagraficaDTO update(AnagraficaUpdateDTO dto);

	void delete(UUID id);
	
}
