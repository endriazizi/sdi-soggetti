package it.iccs.simeal.sdi.soggetti.application.port.inbound.service;

import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ContattoService {

	ContattoDTO create(ContattoCreateDTO dto);

	List<ContattoDTO> findByIds(List<UUID> ids);

	Page<ContattoDTO> search(ContattoCriteria criteria, Pageable pageRequest);

	ContattoDTO update(ContattoUpdateDTO dto);

	void delete(UUID id);
	
}
