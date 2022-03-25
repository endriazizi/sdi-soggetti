package it.iccs.simeal.sdi.domande.application.port.outbound.persistence;

import it.iccs.simeal.sdi.domande.application.model.DomandaModel;
import it.iccs.simeal.sdi.domande.application.port.inbound.service.model.DomandaCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DomandaPersistence {
	
	DomandaModel save(DomandaModel model);
	
	List<DomandaModel> findByIds(List<UUID> ids);
	
	Page<DomandaModel> search(DomandaCriteria criteria, Pageable pageRequest);
	
	void delete(UUID id);

}
