package it.iccs.simeal.sdi.domande.adapter.outbound.persistence.repository.specification;

import it.iccs.simeal.sdi.domande.adapter.outbound.persistence.repository.entity.DomandaEntity;
import it.iccs.simeal.sdi.domande.adapter.outbound.persistence.repository.entity.DomandaEntity;
import it.iccs.simeal.sdi.domande.application.port.inbound.service.model.DomandaCriteria;
import org.springframework.data.jpa.domain.Specification;

public class DomandaSpecification extends AbstractSpecification<DomandaEntity> {
	
	public Specification<DomandaEntity> filter(DomandaCriteria criteria) {

		String flagName = "flagElimina";
		Short flagValue = 0;

		Specification<DomandaEntity> specification =
				super.flagSpecification(flagName, flagValue)
				.and(super.applyInUUIDFilter(criteria.getId(), "id"));
        return specification;
	}

}
