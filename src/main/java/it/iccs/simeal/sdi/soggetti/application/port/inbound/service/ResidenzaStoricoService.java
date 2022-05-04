package it.iccs.simeal.sdi.soggetti.application.port.inbound.service;

import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ResidenzaStoricoService {
	
	ResidenzaStoricoDTO create(ResidenzaStoricoCreateDTO dto);

	List<ResidenzaStoricoDTO> findByIds(List<UUID> ids);

	Page<ResidenzaStoricoDTO> search(ResidenzaStoricoCriteria criteria, Pageable pageRequest);

	ResidenzaStoricoDTO update(ResidenzaStoricoUpdateDTO dto);

	void delete(UUID id);
	
}
