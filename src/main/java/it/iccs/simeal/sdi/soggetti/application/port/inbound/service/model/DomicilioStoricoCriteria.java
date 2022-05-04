package it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class DomicilioStoricoCriteria {
	
	List<UUID> id = new ArrayList<>();
//	List<StringFilter> cognome = new ArrayList<>();
	List<UUID> anagrafica = new ArrayList<>();

	// Short flagElimina;
//	List<IntegerFilter> anno = new ArrayList<>();
//	List<UUID> idRichiedente1 = new ArrayList<>();
//	List<UUID> idBeneficiario = new ArrayList<>();
//	List<UUID> idStatoDomanda = new ArrayList<>();
//	List<UUID> idIstituto = new ArrayList<>();
//	List<UUID> idClasse = new ArrayList<>();
//	List<UUID> idSezione = new ArrayList<>();
}
