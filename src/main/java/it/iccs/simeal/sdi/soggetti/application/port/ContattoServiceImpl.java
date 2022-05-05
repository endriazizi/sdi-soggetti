package it.iccs.simeal.sdi.soggetti.application.port;

import it.iccs.simeal.sdi.soggetti.application.mapper.ContattoModelMapper;

import it.iccs.simeal.sdi.soggetti.application.model.ContattoModel;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.ContattoService;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.*;
import it.iccs.simeal.sdi.soggetti.application.port.outbound.persistence.ContattoPersistence;
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
public class ContattoServiceImpl implements ContattoService {

    @Autowired
    private ContattoModelMapper contattoModelMapper;

    @Autowired
    private ContattoPersistence contattoPersistence;


    @Override
    public ContattoDTO create(ContattoCreateDTO dto) {

        System.out.println(dto);

        ContattoDTO contattoDTO = contattoModelMapper.fromCreateDto(dto);

       // this.checkValidate(residenzaDTO);

        ContattoModel contattoModel = contattoModelMapper.toModel(contattoDTO);
        ContattoModel model = contattoPersistence.save(contattoModel);

        return contattoModelMapper.toDto(model);
    }

    @Override
    public List<ContattoDTO> findByIds(List<UUID> ids) {
        List<ContattoModel> models = contattoPersistence.findByIds(ids);
        return contattoModelMapper.toDto(models);
    }

    @Override
    public Page<ContattoDTO> search(ContattoCriteria criteria, Pageable pageRequest) {
        //criteria.setElimina((short)1);
        Page<ContattoModel> models = contattoPersistence.search(criteria, pageRequest);
        return models.map(model -> this.contattoModelMapper.toDto(model));
    }

//	@Override
//	public Page<AnagraficaDTO> searchEliminati(AnagraficaCriteria criteria, Pageable pageRequest) {
//		//criteria.setElimina((short)1);
//		Page<AnagraficaModel> models = anagraficaPersistence.search(criteria, pageRequest);
//		return models.map(model -> this.anagraficaModelMapper.toDto(model));
//	}

    @Override
    public ContattoDTO update(ContattoUpdateDTO dto) {
        ContattoDTO contattoDTO = contattoModelMapper.fromUpdateDto(dto);
//		this.checkValidate(anagraficaDTO);
//		this.checkDomandaExists(anagraficaDTO.getId());
        ContattoModel residenzaModel = contattoModelMapper.toModel(contattoDTO);
        contattoPersistence.save(residenzaModel);
        ContattoModel model = contattoPersistence.findByIds(Collections.singletonList(contattoDTO.getId()))
                .stream()
                .findAny()
                .orElse(null);
        return contattoModelMapper.toDto(model);
    }

    @Override
    public void delete(UUID id) {
//		this.checkDomandaExists(id);
        ContattoDTO anagraficaDTO = this.findByIds(Collections.singletonList(id))
                .stream()
                .findAny()
                .orElse(null);
        anagraficaDTO.setFlagElimina((short) 1);

        ContattoModel contattoModel = contattoModelMapper.toModel(anagraficaDTO);
        contattoPersistence.save(contattoModel);
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
