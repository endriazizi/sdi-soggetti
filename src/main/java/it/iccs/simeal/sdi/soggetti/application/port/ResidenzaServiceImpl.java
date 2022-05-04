package it.iccs.simeal.sdi.soggetti.application.port;

import it.iccs.simeal.sdi.soggetti.application.mapper.AnagraficaModelMapper;
import it.iccs.simeal.sdi.soggetti.application.mapper.DomandaModelMapper;
import it.iccs.simeal.sdi.soggetti.application.mapper.ResidenzaModelMapper;
import it.iccs.simeal.sdi.soggetti.application.model.AnagraficaModel;
import it.iccs.simeal.sdi.soggetti.application.model.ResidenzaModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.AnagraficaService;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.ResidenzaService;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.*;
import it.iccs.simeal.sdi.soggetti.application.port.outbound.client.TabelleClient;
import it.iccs.simeal.sdi.soggetti.application.port.outbound.persistence.AnagraficaPersistence;
import it.iccs.simeal.sdi.soggetti.application.port.outbound.persistence.DomandaPersistence;
import it.iccs.simeal.sdi.soggetti.application.port.outbound.persistence.ResidenzaPersistence;
import it.iccs.simeal.sdi.soggetti.web.rest.errors.BadRequestException;
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
public class ResidenzaServiceImpl implements ResidenzaService {

    @Autowired
    private ResidenzaModelMapper residenzaModelMapper;

    @Autowired
    private ResidenzaPersistence residenzaPersistence;


    @Override
    public ResidenzaDTO create(ResidenzaCreateDTO dto) {

        System.out.println(dto);

        ResidenzaDTO residenzaDTO = residenzaModelMapper.fromCreateDto(dto);

       // this.checkValidate(residenzaDTO);

        ResidenzaModel residenzaModel = residenzaModelMapper.toModel(residenzaDTO);
        ResidenzaModel model = residenzaPersistence.save(residenzaModel);

        return residenzaModelMapper.toDto(model);
    }

    @Override
    public List<ResidenzaDTO> findByIds(List<UUID> ids) {
        List<ResidenzaModel> models = residenzaPersistence.findByIds(ids);
        return residenzaModelMapper.toDto(models);
    }

    @Override
    public Page<ResidenzaDTO> search(ResidenzaCriteria criteria, Pageable pageRequest) {
        //criteria.setElimina((short)1);
        Page<ResidenzaModel> models = residenzaPersistence.search(criteria, pageRequest);
        return models.map(model -> this.residenzaModelMapper.toDto(model));
    }

//	@Override
//	public Page<AnagraficaDTO> searchEliminati(AnagraficaCriteria criteria, Pageable pageRequest) {
//		//criteria.setElimina((short)1);
//		Page<AnagraficaModel> models = anagraficaPersistence.search(criteria, pageRequest);
//		return models.map(model -> this.anagraficaModelMapper.toDto(model));
//	}

    @Override
    public ResidenzaDTO update(ResidenzaUpdateDTO dto) {
        ResidenzaDTO residenzaDTO = residenzaModelMapper.fromUpdateDto(dto);
//		this.checkValidate(anagraficaDTO);
//		this.checkDomandaExists(anagraficaDTO.getId());
        ResidenzaModel residenzaModel = residenzaModelMapper.toModel(residenzaDTO);
        residenzaPersistence.save(residenzaModel);
        ResidenzaModel model = residenzaPersistence.findByIds(Collections.singletonList(residenzaDTO.getId()))
                .stream()
                .findAny()
                .orElse(null);
        return residenzaModelMapper.toDto(model);
    }

    @Override
    public void delete(UUID id) {
//		this.checkDomandaExists(id);
        ResidenzaDTO anagraficaDTO = this.findByIds(Collections.singletonList(id))
                .stream()
                .findAny()
                .orElse(null);
        anagraficaDTO.setFlagElimina((short) 1);

        ResidenzaModel residenzaModel = residenzaModelMapper.toModel(anagraficaDTO);
        residenzaPersistence.save(residenzaModel);
    }
//
//	private void checkDomandaExists(UUID id) {
//		if (domandaPersistence.findByIds(Collections.singletonList(id)).isEmpty()) {
//			log.warn("Domanda {} not found", id);
//			throw new NotFoundException(String.format("Domanda %s non trovato", id));
//		}
//	}
//

    private void checkValidate(AnagraficaDTO anagraficaDTO) {

        Boolean error = false;
        String error_validate = "";

        System.out.println(anagraficaDTO);

        String value = anagraficaDTO.getTipologiaSoggetto().getValue();


        if ((anagraficaDTO.getTipologiaSoggetto() == null || (anagraficaDTO.getTipologiaSoggetto().getValue().equals("Persona Fisica")))) {
//            if (error_validate != "")
//                error_validate += ", ";
//
//            error_validate += "Anno non rilevato";
//            error = true;

            if ((anagraficaDTO.getCognome() == null )) {
                if (error_validate != "")
                    error_validate += ", ";

                error_validate += "Cognome non rilevato";
                error = true;
            }
        }
//		if((domandaDTO.getAnno()==null || domandaDTO.getAnno()==0))
//		{
//			if(error_validate!="")
//				error_validate+=", ";
//
//			error_validate+="Anno non rilevato";
//			error=true;
//		}

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

        if (error) {
            log.warn("Domanda error: {}", error_validate);
            throw new BadRequestException(String.format("Errore creazione Domanda error: %s", error_validate));
        }

    }
}
