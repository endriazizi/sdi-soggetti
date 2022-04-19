package it.iccs.simeal.sdi.soggetti.application.port;

import it.iccs.simeal.sdi.soggetti.application.mapper.AnagraficaModelMapper;
import it.iccs.simeal.sdi.soggetti.application.mapper.DomandaModelMapper;
import it.iccs.simeal.sdi.soggetti.application.model.AnagraficaModel;
import it.iccs.simeal.sdi.soggetti.application.model.DomandaModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.AnagraficaService;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.DomandaService;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.*;
import it.iccs.simeal.sdi.soggetti.application.port.outbound.client.TabelleClient;
import it.iccs.simeal.sdi.soggetti.application.port.outbound.persistence.AnagraficaPersistence;
import it.iccs.simeal.sdi.soggetti.application.port.outbound.persistence.DomandaPersistence;
import it.iccs.simeal.sdi.soggetti.web.rest.errors.BadRequestException;
import it.iccs.simeal.sdi.soggetti.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class AnagraficaServiceImpl implements AnagraficaService {

	@Autowired
	private DomandaModelMapper domandaModelMapper;

	@Autowired
	private AnagraficaModelMapper anagraficaModelMapper;
	
	@Autowired
	private DomandaPersistence domandaPersistence;

	@Autowired
	private AnagraficaPersistence anagraficaPersistence;

	@Autowired
	private TabelleClient tabelleClient;

	@Override
	public AnagraficaDTO create(AnagraficaCreateDTO dto) {
		return null;
	}

//	@Override
//	public AnagraficaDTO create(AnagraficaCreateDTO dto) {
//
//		System.out.println(dto);
//
//		AnagraficaDTO anagraficaDTO = anagraficaModelMapper.fromCreateDto(dto);
//
//		//this.checkValidate(anagraficaDTO);
//
//		AnagraficaModel anagraficaModel = anagraficaModelMapper.toModel(anagraficaDTO);
//		AnagraficaModel model = anagraficaPersistence.save(anagraficaModel);
//
//        return anagraficaModelMapper.toDto(model);
//	}

//	@Override
//	public List<DomandaDTO> findByIds(List<UUID> ids) {
//		List<DomandaModel> models = domandaPersistence.findByIds(ids);
//		return domandaModelMapper.toDto(models);
//	}
//
//	@Override
//	public Page<DomandaDTO> search(DomandaCriteria criteria, Pageable pageRequest) {
//		Page<DomandaModel> models = domandaPersistence.search(criteria, pageRequest);
//		return models.map(model -> this.domandaModelMapper.toDto(model));
//	}
//
//	@Override
//	public DomandaDTO update(DomandaUpdateDTO dto) {
//		DomandaDTO domandaDTO = domandaModelMapper.fromUpdateDto(dto);
//		this.checkValidate(domandaDTO);
//		this.checkDomandaExists(domandaDTO.getId());
//        DomandaModel annoModel = domandaModelMapper.toModel(domandaDTO);
//        domandaPersistence.save(annoModel);
//        DomandaModel model = domandaPersistence.findByIds(Collections.singletonList(domandaDTO.getId()))
//                .stream()
//                .findAny()
//                .orElse(null);
//        return domandaModelMapper.toDto(model);
//	}
//
//	@Override
//	public void delete(UUID id) {
//		this.checkDomandaExists(id);
//		DomandaDTO domandaDTO = this.findByIds(Collections.singletonList(id))
//				.stream()
//				.findAny()
//				.orElse(null);
//		domandaDTO.setFlagElimina((short)1);
//
//		DomandaModel domandaModel = domandaModelMapper.toModel(domandaDTO);
//		domandaPersistence.save(domandaModel);
//	}
//
//	private void checkDomandaExists(UUID id) {
//		if (domandaPersistence.findByIds(Collections.singletonList(id)).isEmpty()) {
//			log.warn("Domanda {} not found", id);
//			throw new NotFoundException(String.format("Domanda %s non trovato", id));
//		}
//	}
//

//	private void checkValidate(DomandaDTO domandaDTO) {
//
//		Boolean error=false;
//		String error_validate="";
//
//		System.out.println(domandaDTO);
//
//		if((domandaDTO.getAnno()==null || domandaDTO.getAnno()==0))
//		{
//			if(error_validate!="")
//				error_validate+=", ";
//
//			error_validate+="Anno non rilevato";
//			error=true;
//		}
//
//		if(domandaDTO.getIdTipologiaDomanda()==null)
//		{
//			if(error_validate!="")
//				error_validate+=", ";
//
//			error_validate+="TipologiaDomanda non rilevata";
//			error=true;
//		}
//
//		if(domandaDTO.getIdRichiedente1()==null)
//		{
//			if(error_validate!="")
//				error_validate+=", ";
//
//			error_validate+="IdRichiedente1 non rilevato";
//			error=true;
//		}
//
//		if(domandaDTO.getIdBeneficiario()==null)
//		{
//			if(error_validate!="")
//				error_validate+=", ";
//
//			error_validate+="IdBeneficiario non rilevato";
//			error=true;
//		}
//
//		if(domandaDTO.getIdStatoDomanda()==null)
//		{
//			if(error_validate!="")
//				error_validate+=", ";
//
//			error_validate+="StatoDomanda non rilevato";
//			error=true;
//		}
//
//		if(domandaDTO.getIdStatoDomanda()!=null)
//		{
//			Boolean stato_domanda_exists=tabelleClient.checkStatoDomandaExists(domandaDTO.getIdStatoDomanda());
//			System.out.println("StatoDomandaExists: "+stato_domanda_exists);
//			if(!stato_domanda_exists)
//			{
//				if(error_validate!="")
//					error_validate+=", ";
//
//				error_validate+="StatoDomandaExists non valido";
//				error=true;
//			}
//		}
//
//		if(domandaDTO.getIdIstituto()!=null)
//		{
//			Boolean istituto_exists=tabelleClient.checkIstitutoExists(domandaDTO.getIdIstituto());
//			System.out.println("IstitutoExists: "+istituto_exists);
//			if(!istituto_exists)
//			{
//				if(error_validate!="")
//					error_validate+=", ";
//
//				error_validate+="Istituto non valido";
//				error=true;
//			}
//		}
//
//		if(domandaDTO.getIdClasse()!=null)
//		{
//			Boolean classe_exists=tabelleClient.checkClasseExists(domandaDTO.getIdClasse());
//			System.out.println("ClasseExists: "+classe_exists);
//			if(!classe_exists)
//			{
//				if(error_validate!="")
//					error_validate+=", ";
//
//				error_validate+="Classe non valida";
//				error=true;
//			}
//		}
//
//		if(domandaDTO.getIdSezione()!=null)
//		{
//			Boolean sezione_exists=tabelleClient.checkSezioneExists(domandaDTO.getIdSezione());
//			System.out.println("SezioneExists: "+sezione_exists);
//			if(!sezione_exists)
//			{
//				if(error_validate!="")
//					error_validate+=", ";
//
//				error_validate+="Sezione non valida";
//				error=true;
//			}
//		}
//
//		if(error)
//		{
//			log.warn("Domanda error: {}", error_validate);
//			throw new BadRequestException(String.format("Errore creazione Domanda error: %s", error_validate));
//		}
//
//	}
}
