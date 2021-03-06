package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.specification;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.ResidenzaEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.ResidenzaStoricoEntity;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.ResidenzaCriteria;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.ResidenzaStoricoCriteria;
import org.springframework.data.jpa.domain.Specification;

public class ResidenzaStoricoSpecification extends AbstractSpecification<ResidenzaStoricoEntity> {
	
	public Specification<ResidenzaStoricoEntity> filter(ResidenzaStoricoCriteria criteria) {

		// http://localhost:8092/api/anagrafica/ricerca?flagelimina=0
		String flagName = "flagElimina";
		Short flagValue = 0;

		Specification<ResidenzaStoricoEntity> specification =
			super.flagSpecification(flagName, flagValue);
//				.and(super.applyInUUIDFilter(criteria.getId(), "id"))
//				.and(super.applyIntegerFilter(criteria.getAnno(), "anno"))
//				.and(super.applyInUUIDFilter(criteria.getIdRichiedente1(), "id_richiedente1"))
//				.and(super.applyInUUIDFilter(criteria.getIdBeneficiario(), "id_beneficiario"))
//				.and(super.applyInUUIDFilter(criteria.getIdStatoDomanda(), "id_stato_domanda"))
//				.and(super.applyInUUIDFilter(criteria.getIdIstituto(), "id_istituto"))
//		     	.and(super.applyInUUIDFilter(criteria.getIdClasse(), "id_classe"))
//				.and(super.applyInUUIDFilter(criteria.getIdSezione(), "id_sezione"));

//				.and(super.applySearchFilter(criteria.getCognome(), "cognome"));

				//.and(super.flagSpecification("flagElimina", criteria.getFlagElimina()));
		return specification;
	}

}
