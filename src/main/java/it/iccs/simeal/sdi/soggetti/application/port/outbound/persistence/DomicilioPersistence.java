package it.iccs.simeal.sdi.soggetti.application.port.outbound.persistence;

import it.iccs.simeal.sdi.soggetti.application.model.DomicilioModel;
import it.iccs.simeal.sdi.soggetti.application.model.ResidenzaModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomicilioCriteria;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.ResidenzaCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DomicilioPersistence {
	
	DomicilioModel save(DomicilioModel model);
	
	List<DomicilioModel> findByIds(List<UUID> ids);

	Page<DomicilioModel> search(DomicilioCriteria criteria, Pageable pageRequest);

	void delete(UUID id);

}
