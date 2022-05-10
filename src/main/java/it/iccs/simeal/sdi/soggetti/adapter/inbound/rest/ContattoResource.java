package it.iccs.simeal.sdi.soggetti.adapter.inbound.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.ContattoService;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.DomandaService;
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
@RequestMapping("/api/contatto" +
        "")
public class ContattoResource {

    @Autowired
    private ContattoService contattoService;

    @Autowired
    private DomandaService domandaService;

    @Operation(summary = "Crea una Contatto", description = "La creazione non richiede campi obbligatori", tags = { "Contatto Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contatto creato", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @PostMapping
    public ResponseEntity<ContattoDTO> createContatto(@Validated @RequestBody ContattoCreateDTO dto) {
        log.debug("REST request to create Contatto: {}", dto);
        return new ResponseEntity<>(contattoService.create(dto), HttpStatus.OK);
    }

    @Operation(summary = "Recupera tutte le Contatto che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Contatto Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contatto trovato", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "204", description = "Nessun Contatto trovato", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })

    @GetMapping(params = {"ids"})
    public ResponseEntity<List<ContattoDTO>> findContattoByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
        log.debug("REST request to find any Contatto {}", ids);
        List<ContattoDTO> dtos = contattoService.findByIds(ids);
        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }

    @Operation(summary = "Recupera tutti le Contatto che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Contatto Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contatto trovata"),
            @ApiResponse(responseCode = "204", description = "Nessuna Contatto trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @GetMapping("/ricerca")
    public ResponseEntity<Page<ContattoDTO>> searchContatto(ContattoCriteria criteria, Pageable pageRequest) {
        log.debug("REST request to search Contatto: {} {}", criteria, pageRequest);
        Page<ContattoDTO> results = contattoService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
    }

    @Operation(summary = "Aggiorna una Contatto", description = "L'aggiornamento richiede obbligatoriamente l'id della Contatto da aggiornare", tags = { "Contatto Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contatto aggiornata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Contatto non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @PutMapping()
    public ResponseEntity<ContattoDTO> updateDomanda(@Validated @RequestBody ContattoUpdateDTO dto) {
        log.debug("REST request to update Domanda: {}", dto);
        return new ResponseEntity<>(contattoService.update(dto), HttpStatus.OK);
    }


    @Operation(summary = "Elimina una Contatto", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Contatto Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contatto eliminata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Contatto non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContatto(@PathVariable("id") UUID id) {
        log.debug("REST request to delete Contatto: {}", id);
        contattoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
