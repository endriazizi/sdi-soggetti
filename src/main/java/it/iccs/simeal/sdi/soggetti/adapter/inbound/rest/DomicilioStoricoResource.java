package it.iccs.simeal.sdi.soggetti.adapter.inbound.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.DomicilioService;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.DomicilioStoricoService;
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
@RequestMapping("/api/domiciliostorico")
public class DomicilioStoricoResource {

    @Autowired
    private DomicilioStoricoService domicilioStoricoService;

    @Operation(summary = "Crea una Domicilio Storico", description = "La creazione non richiede campi obbligatori", tags = { "Domicilio Storico Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Domicilio Storico Soggetto creato", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @PostMapping
    public ResponseEntity<DomicilioStoricoDTO> createDomicilioStorico(@Validated @RequestBody DomicilioStoricoCreateDTO dto) {
        log.debug("REST request to create Domicilio Storico: {}", dto);
        return new ResponseEntity<>(domicilioStoricoService.create(dto), HttpStatus.OK);
    }

    @Operation(summary = "Recupera tutte le Domicilio Storico che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Domicilio Storico Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Domicilio Storico trovata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "204", description = "Nessuna Domicilio Storico trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })

    @GetMapping(params = {"ids"})
    public ResponseEntity<List<DomicilioStoricoDTO>> findDomicilioStoricoByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
        log.debug("REST request to find any Domicilio Storico {}", ids);
        List<DomicilioStoricoDTO> dtos = domicilioStoricoService.findByIds(ids);
        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }

    @Operation(summary = "Recupera tutti le Domicilio Storico che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Domicilio Storico Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Domicilio Storico trovata"),
            @ApiResponse(responseCode = "204", description = "Nessuna Domicilio Storico trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @GetMapping("/ricerca")
    public ResponseEntity<Page<DomicilioStoricoDTO>> searchDomicilioStorico(DomicilioStoricoCriteria criteria, Pageable pageRequest) {
        log.debug("REST request to search Domicilio Storico: {} {}", criteria, pageRequest);
        Page<DomicilioStoricoDTO> results = domicilioStoricoService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
    }

    @Operation(summary = "Aggiorna una Domicilio Storico", description = "L'aggiornamento richiede obbligatoriamente l'id della Domicilio Storico da aggiornare", tags = { "Domicilio Storico Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Domicilio Storico aggiornata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Domicilio Storico non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @PutMapping()
    public ResponseEntity<DomicilioStoricoDTO> updateDomicilioStorico(@Validated @RequestBody DomicilioStoricoUpdateDTO dto) {
        log.debug("REST request to update Domicilio Storico: {}", dto);
        return new ResponseEntity<>(domicilioStoricoService.update(dto), HttpStatus.OK);
    }


    @Operation(summary = "Elimina una Domicilio Storico", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Domicilio Storico Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Domicilio Storico eliminata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Domicilio Storico non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDomicilioStorico(@PathVariable("id") UUID id) {
        log.debug("REST request to delete Domicilio Storico: {}", id);
        domicilioStoricoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
