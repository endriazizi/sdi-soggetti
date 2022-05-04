package it.iccs.simeal.sdi.soggetti.application.port.outbound.persistence;

import it.iccs.simeal.sdi.soggetti.application.model.DomicilioModel;
import it.iccs.simeal.sdi.soggetti.application.model.DomicilioStoricoModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomicilioCriteria;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomicilioDTO;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomicilioStoricoCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DomicilioStoricoPersistence {
	
	DomicilioStoricoModel save(DomicilioStoricoModel model);
	
	List<DomicilioStoricoModel> findByIds(List<UUID> ids);

	Page<DomicilioStoricoModel> search(DomicilioStoricoCriteria criteria, Pageable pageRequest);

	void delete(UUID id);

}
