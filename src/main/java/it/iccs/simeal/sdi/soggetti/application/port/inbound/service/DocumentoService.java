package it.iccs.simeal.sdi.soggetti.application.port.inbound.service;

import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DocumentoService {
	
	DocumentoDTO create(DocumentoCreateDTO dto);

	List<DocumentoDTO> findByIds(List<UUID> ids);

	Page<DocumentoDTO> search(DocumentoCriteria criteria, Pageable pageRequest);

	DocumentoDTO update(DocumentoUpdateDTO dto);

	void delete(UUID id);
	
}
