package it.iccs.simeal.sdi.soggetti.application.port.outbound.persistence;

import it.iccs.simeal.sdi.soggetti.application.model.AnagraficaModel;
import it.iccs.simeal.sdi.soggetti.application.model.ResidenzaModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.AnagraficaCriteria;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.ResidenzaCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ResidenzaPersistence {
	
	ResidenzaModel save(ResidenzaModel model);
	
	List<ResidenzaModel> findByIds(List<UUID> ids);

	Page<ResidenzaModel> search(ResidenzaCriteria criteria, Pageable pageRequest);

	void delete(UUID id);

}
