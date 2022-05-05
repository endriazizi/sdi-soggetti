package it.iccs.simeal.sdi.soggetti.adapter.inbound.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.DomandaService;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.ResidenzaService;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.zalando.problem.Problem;

@Slf4j
@RestController
@RequestMapping("/api/residenza")
public class ResidenzaResource {

    @Autowired
    private ResidenzaService residenzaService;

    @Autowired
    private DomandaService domandaService;

    @Operation(summary = "Crea una Residenza", description = "La creazione non richiede campi obbligatori", tags = { "Residenza Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Residenza Soggetto creata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @PostMapping
    public ResponseEntity<ResidenzaDTO> createResidenza(@Validated @RequestBody ResidenzaCreateDTO dto) {
        log.debug("REST request to create Residenza: {}", dto);
        return new ResponseEntity<>(residenzaService.create(dto), HttpStatus.OK);
    }

//    @Operation(summary = "Crea una Residenza", description = "La creazione non richiede campi obbligatori", tags = { "Residenza Resource" } )
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Residenza Soggetto creata", content = {
//                    @Content(mediaType = "application/json")}),
//            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
//            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
//    })
//    @PostMapping
//    public ResponseEntity<ResidenzaDTO> createResidenza(@Validated @RequestBody ResidenzaCreateDTO dto) {
//        log.debug("REST request to create Residenza: {}", dto);
//        return new ResponseEntity<>(residenzaService.create(dto), HttpStatus.OK);
//    }

//    @Operation(summary = "Recupera tutte le Anagrafiche che soddisfano gli id inseriti",
//            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Anagrafica Resource" } )
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Anagrafica trovata", content = {
//                    @Content(mediaType = "application/json")}),
//            @ApiResponse(responseCode = "204", description = "Nessuna Anagrafica trovata", content = {
//                    @Content(mediaType = "application/json", schema = @Schema())}),
//            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
//            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
//    })
//
//    @GetMapping(params = {"ids"})
//    public ResponseEntity<List<AnagraficaDTO>> findAnagraficaByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
//        log.debug("REST request to find any Anagrafica {}", ids);
//        List<AnagraficaDTO> dtos = anagraficaService.findByIds(ids);
//        if (dtos.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(dtos, HttpStatus.OK);
//        }
//    }
//
//    @Operation(summary = "Recupera tutti le Anagrafiche che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Anagrafica Resource" } )
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Anagrafica trovata"),
//            @ApiResponse(responseCode = "204", description = "Nessuna Anagrafica trovata", content = {
//                    @Content(mediaType = "application/json", schema = @Schema())}),
//            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
//            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
//    })
//    @GetMapping("/ricerca")
//    public ResponseEntity<Page<AnagraficaDTO>> searchAnagrafica(AnagraficaCriteria criteria, Pageable pageRequest) {
//        log.debug("REST request to search Anagrafica: {} {}", criteria, pageRequest);
//        Page<AnagraficaDTO> results = anagraficaService.search(criteria, pageRequest);
//        if (results.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(results, HttpStatus.OK);
//        }
//    }
//
//    @Operation(summary = "Aggiorna una Anagrafica", description = "L'aggiornamento richiede obbligatoriamente l'id della Anagrafica da aggiornare", tags = { "Anagrafica Resource" } )
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Anagrafica aggiornata", content = {
//                    @Content(mediaType = "application/json")}),
//            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
//            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
//            @ApiResponse(responseCode = "404", description = "Anagrafica non esiste", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
//    })
//    @PutMapping()
//    public ResponseEntity<AnagraficaDTO> updateDomanda(@Validated @RequestBody AnagraficaUpdateDTO dto) {
//        log.debug("REST request to update Domanda: {}", dto);
//        return new ResponseEntity<>(anagraficaService.update(dto), HttpStatus.OK);
//    }
//
//
//    @Operation(summary = "Elimina una Anagrafica", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Anagrafica Resource" } )
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Anagrafica eliminata", content = {
//                    @Content(mediaType = "application/json")}),
//            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
//            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
//            @ApiResponse(responseCode = "404", description = "Anagrafica non esiste", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
//    })
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteAnagrafica(@PathVariable("id") UUID id) {
//        log.debug("REST request to delete Anagrafica: {}", id);
//        anagraficaService.delete(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
