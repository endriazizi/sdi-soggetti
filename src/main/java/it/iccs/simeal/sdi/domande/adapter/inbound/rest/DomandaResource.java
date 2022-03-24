package it.iccs.simeal.sdi.domande.adapter.inbound.rest;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zalando.problem.Problem;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/domanda")
public class DomandaResource {

    @Operation(summary = "Crea una Domanda", description = "La creazione non richiede campi obbligatori", tags = { "Domanda Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Domanda creata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @PostMapping
    public String createDomanda() {
        log.debug("REST request to create Domanda");
        return "Domanda creata correttamente";
    }

    @Operation(summary = "Recupera tutte le Domande che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Domanda Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anno trovato", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "204", description = "Nessun Anno trovato", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @GetMapping(params = {"ids"})
    public String findDomandaByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
        log.debug("REST request to find any Domanda {}", ids);
        return "Domande trovate";
    }

    @Operation(summary = "Aggiorna una Domanda", description = "L'aggiornamento richiede obbligatoriamente l'id della Domanda da aggiornare", tags = { "Domanda Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Domanda aggiornata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Anno non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @PutMapping()
    public String updateDomanda() {
        log.debug("REST request to update Domanda");
        return "Domanda aggiornata correttamente";
    }


    @Operation(summary = "Elimina una Domanda", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Domanda Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Domanda eliminata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Anno non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @DeleteMapping("/{id}")
    public String deleteDomanda(@PathVariable("id") UUID id) {
        log.debug("REST request to delete Domanda: {}", id);
        return "Domanda eliminata correttamente";
    }
}
