package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.specification;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.DomandaEntity;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomandaCriteria;
import org.springframework.data.jpa.domain.Specification;

public class DomandaSpecification extends AbstractSpecification<DomandaEntity> {
	
	public Specification<DomandaEntity> filter(DomandaCriteria criteria) {

		String flagName = "flagElimina";
		Short flagValue = 0;

		Specification<DomandaEntity> specification =
				super.flagSpecification(flagName, flagValue)
				.and(super.applyInUUIDFilter(criteria.getId(), "id"))
				.and(super.applyIntegerFilter(criteria.getAnno(), "anno"))
				.and(super.applyInUUIDFilter(criteria.getIdRichiedente1(), "id_richiedente1"))
				.and(super.applyInUUIDFilter(criteria.getIdBeneficiario(), "id_beneficiario"))
				.and(super.applyInUUIDFilter(criteria.getIdStatoDomanda(), "id_stato_domanda"))
				.and(super.applyInUUIDFilter(criteria.getIdIstituto(), "id_istituto"))
		     	.and(super.applyInUUIDFilter(criteria.getIdClasse(), "id_classe"))
				.and(super.applyInUUIDFilter(criteria.getIdSezione(), "id_sezione"));
		return specification;
	}

}
