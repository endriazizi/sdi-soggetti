package it.iccs.simeal.sdi.domande.application.port.inbound.service.model;

import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class DomandaCriteria {
	
	List<UUID> id = new ArrayList<>();
	List<IntegerFilter> anno = new ArrayList<>();
	List<UUID> idRichiedente1 = new ArrayList<>();
	List<UUID> idBeneficiario = new ArrayList<>();
	List<UUID> idIstituto = new ArrayList<>();
	List<UUID> idClasse = new ArrayList<>();
	List<UUID> idSezione = new ArrayList<>();
}
