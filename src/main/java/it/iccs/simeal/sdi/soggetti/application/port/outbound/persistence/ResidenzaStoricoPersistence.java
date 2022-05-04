package it.iccs.simeal.sdi.soggetti.application.port.outbound.persistence;

import it.iccs.simeal.sdi.soggetti.application.model.ResidenzaModel;
import it.iccs.simeal.sdi.soggetti.application.model.ResidenzaStoricoModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.ResidenzaCriteria;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.ResidenzaStoricoCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ResidenzaStoricoPersistence {
	
	ResidenzaStoricoModel save(ResidenzaStoricoModel model);
	
	List<ResidenzaStoricoModel> findByIds(List<UUID> ids);

	Page<ResidenzaStoricoModel> search(ResidenzaStoricoCriteria criteria, Pageable pageRequest);

	void delete(UUID id);

}
