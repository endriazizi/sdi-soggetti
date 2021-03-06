//package it.iccs.simeal.sdi.soggetti.adapter.inbound.rest;
//
//import java.util.List;
//import java.util.UUID;
//
//import javax.validation.constraints.NotNull;
//
//import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.DomandaService;
//import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomandaCreateDTO;
//import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomandaCriteria;
//import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomandaDTO;
//import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DomandaUpdateDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.zalando.problem.Problem;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@RestController
//@RequestMapping("/api/domanda")
//public class DomandeResource {
//
//    @Autowired
//    private DomandaService domandaService;
//
//    @Operation(summary = "Crea una Domanda", description = "La creazione non richiede campi obbligatori", tags = { "Domanda Resource" } )
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Domanda creata", content = {
//                    @Content(mediaType = "application/json")}),
//            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
//            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
//    })
//    @PostMapping
//    public ResponseEntity<DomandaDTO> createDomanda(@Validated @RequestBody DomandaCreateDTO dto) {
//        log.debug("REST request to create Anno: {}", dto);
//        return new ResponseEntity<>(domandaService.create(dto), HttpStatus.OK);
//    }
//
//    @Operation(summary = "Recupera tutte le Domande che soddisfano gli id inseriti",
//            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Domanda Resource" } )
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Domanda trovata", content = {
//                    @Content(mediaType = "application/json")}),
//            @ApiResponse(responseCode = "204", description = "Nessun Anno trovato", content = {
//                    @Content(mediaType = "application/json", schema = @Schema())}),
//            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
//            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
//    })
//
//    @GetMapping(params = {"ids"})
//    public ResponseEntity<List<DomandaDTO>> findDomandaByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
//        log.debug("REST request to find any Domanda {}", ids);
//        List<DomandaDTO> dtos = domandaService.findByIds(ids);
//        if (dtos.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(dtos, HttpStatus.OK);
//        }
//    }
//
//    @Operation(summary = "Recupera tutte le Domanda che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Domanda Resource" } )
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Domanda trovata"),
//            @ApiResponse(responseCode = "204", description = "Nessuna Domanda trovata", content = {
//                    @Content(mediaType = "application/json", schema = @Schema())}),
//            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
//            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
//    })
//    @GetMapping("/ricerca")
//    public ResponseEntity<Page<DomandaDTO>> searchDomanda(DomandaCriteria criteria, Pageable pageRequest) {
//        log.debug("REST request to search Domanda: {} {}", criteria, pageRequest);
//        Page<DomandaDTO> results = domandaService.search(criteria, pageRequest);
//        if (results.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(results, HttpStatus.OK);
//        }
//    }
//
//    @Operation(summary = "Aggiorna una Domanda", description = "L'aggiornamento richiede obbligatoriamente l'id della Domanda da aggiornare", tags = { "Domanda Resource" } )
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Domanda aggiornata", content = {
//                    @Content(mediaType = "application/json")}),
//            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
//            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
//            @ApiResponse(responseCode = "404", description = "Anno non esiste", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
//    })
//    @PutMapping()
//    public ResponseEntity<DomandaDTO> updateDomanda(@Validated @RequestBody DomandaUpdateDTO dto) {
//        log.debug("REST request to update Domanda: {}", dto);
//        return new ResponseEntity<>(domandaService.update(dto), HttpStatus.OK);
//    }
//
//
//    @Operation(summary = "Elimina una Domanda", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Domanda Resource" } )
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Domanda eliminata", content = {
//                    @Content(mediaType = "application/json")}),
//            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
//            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
//            @ApiResponse(responseCode = "404", description = "Anno non esiste", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
//    })
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteDomanda(@PathVariable("id") UUID id) {
//        log.debug("REST request to delete Domanda: {}", id);
//        domandaService.delete(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}
