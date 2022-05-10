package it.iccs.simeal.sdi.soggetti.adapter.inbound.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.DomicilioService;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.zalando.problem.Problem;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/domicilio")
public class DomicilioResource {

    @Autowired
    private DomicilioService domicilioService;

    @Operation(summary = "Crea una Domicilio", description = "La creazione non richiede campi obbligatori", tags = { "Domicilio Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Domicilio Soggetto creato", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @PostMapping
    public ResponseEntity<DomicilioDTO> createDomicilio(@Validated @RequestBody DomicilioCreateDTO dto) {
        log.debug("REST request to create Domicilio: {}", dto);
        return new ResponseEntity<>(domicilioService.create(dto), HttpStatus.OK);
    }

    @Operation(summary = "Recupera tutte le Domicili che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Domicilio Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Domicilio trovata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "204", description = "Nessuna Domicilio trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })

    @GetMapping(params = {"ids"})
    public ResponseEntity<List<DomicilioDTO>> findDomicilioByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
        log.debug("REST request to find any Domicilio {}", ids);
        List<DomicilioDTO> dtos = domicilioService.findByIds(ids);
        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }

    @Operation(summary = "Recupera tutti le Domicili che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Domicilio Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Domicilio trovata"),
            @ApiResponse(responseCode = "204", description = "Nessuna Domicilio trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @GetMapping("/ricerca")
    public ResponseEntity<Page<DomicilioDTO>> searchDomicilio(DomicilioCriteria criteria, Pageable pageRequest) {
        log.debug("REST request to search Domicilio: {} {}", criteria, pageRequest);
        Page<DomicilioDTO> results = domicilioService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
    }

    @Operation(summary = "Aggiorna una Domicilio", description = "L'aggiornamento richiede obbligatoriamente l'id della Domicilio da aggiornare", tags = { "Domicilio Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Domicilio aggiornata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Domicilio non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @PutMapping()
    public ResponseEntity<DomicilioDTO> updateDomicilio(@Validated @RequestBody DomicilioUpdateDTO dto) {
        log.debug("REST request to update Domicilio: {}", dto);
        return new ResponseEntity<>(domicilioService.update(dto), HttpStatus.OK);
    }


    @Operation(summary = "Elimina una Domicilio", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Domicilio Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Domicilio eliminata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Domicilio non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDomicilio(@PathVariable("id") UUID id) {
        log.debug("REST request to delete Domicilio: {}", id);
        domicilioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
