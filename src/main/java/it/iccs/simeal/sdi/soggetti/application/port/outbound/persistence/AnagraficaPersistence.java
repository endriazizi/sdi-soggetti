package it.iccs.simeal.sdi.soggetti.application.port.outbound.persistence;

import it.iccs.simeal.sdi.soggetti.application.model.AnagraficaModel;
import it.iccs.simeal.sdi.soggetti.application.model.DomandaModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.AnagraficaCriteria;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomandaCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface AnagraficaPersistence {
	
	AnagraficaModel save(AnagraficaModel model);
	
	List<AnagraficaModel> findByIds(List<UUID> ids);

	Page<AnagraficaModel> search(AnagraficaCriteria criteria, Pageable pageRequest);

	void delete(UUID id);

}
