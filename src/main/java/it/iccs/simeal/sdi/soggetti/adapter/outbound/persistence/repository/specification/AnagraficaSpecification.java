package it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.specification;

import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.AnagraficaEntity;
import it.iccs.simeal.sdi.soggetti.adapter.outbound.persistence.repository.entity.DomandaEntity;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.AnagraficaCriteria;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomandaCriteria;
import org.springframework.data.jpa.domain.Specification;

public class AnagraficaSpecification extends AbstractSpecification<AnagraficaEntity> {
	
	public Specification<AnagraficaEntity> filter(AnagraficaCriteria criteria) {

		// http://localhost:8092/api/anagrafica/ricerca?flagelimina=0
		String flagName = "flagElimina";
		Short flagValue = 0;

		Specification<AnagraficaEntity> specification =
			super.flagSpecification(flagName, flagValue)
//				.and(super.applyInUUIDFilter(criteria.getId(), "id"))
//				.and(super.applyIntegerFilter(criteria.getAnno(), "anno"))
//				.and(super.applyInUUIDFilter(criteria.getIdRichiedente1(), "id_richiedente1"))
//				.and(super.applyInUUIDFilter(criteria.getIdBeneficiario(), "id_beneficiario"))
//				.and(super.applyInUUIDFilter(criteria.getIdStatoDomanda(), "id_stato_domanda"))
//				.and(super.applyInUUIDFilter(criteria.getIdIstituto(), "id_istituto"))
//		     	.and(super.applyInUUIDFilter(criteria.getIdClasse(), "id_classe"))
//				.and(super.applyInUUIDFilter(criteria.getIdSezione(), "id_sezione"));
				.and(super.applySearchFilter(criteria.getCognome(), "cognome"));
				//.and(super.flagSpecification("flagElimina", criteria.getFlagElimina()));
		return specification;
	}

}
