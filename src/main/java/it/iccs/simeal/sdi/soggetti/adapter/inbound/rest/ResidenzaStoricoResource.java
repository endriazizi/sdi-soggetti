package it.iccs.simeal.sdi.soggetti.adapter.inbound.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.ResidenzaStoricoService;
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
@RequestMapping("/api/residenzastorico")
public class ResidenzaStoricoResource {

    @Autowired
    private ResidenzaStoricoService residenzaStoricoService;

    @Operation(summary = "Crea una Residenza Storico", description = "La creazione non richiede campi obbligatori", tags = { "Residenza Storico Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Residenza Storico Soggetto creata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @PostMapping
    public ResponseEntity<ResidenzaStoricoDTO> createResidenzaStorico(@Validated @RequestBody ResidenzaStoricoCreateDTO dto) {
        log.debug("REST request to create Residenza Storico: {}", dto);
        return new ResponseEntity<>(residenzaStoricoService.create(dto), HttpStatus.OK);
    }

    @Operation(summary = "Recupera tutte le Residenza Storico che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Residenza Storico Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Residenza Storico trovata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "204", description = "Nessuna Residenza Storico trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })

    @GetMapping(params = {"ids"})
    public ResponseEntity<List<ResidenzaStoricoDTO>> findResidenzaStoricoByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
        log.debug("REST request to find any Residenza Storico {}", ids);
        List<ResidenzaStoricoDTO> dtos = residenzaStoricoService.findByIds(ids);
        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }

    @Operation(summary = "Recupera tutti le Residenza Storico che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Residenza Storico Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Residenza Storico trovata"),
            @ApiResponse(responseCode = "204", description = "Nessuna Residenza Storico trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @GetMapping("/ricerca")
    public ResponseEntity<Page<ResidenzaStoricoDTO>> searchResidenzaStorico(ResidenzaStoricoCriteria criteria, Pageable pageRequest) {
        log.debug("REST request to search Residenza Storico: {} {}", criteria, pageRequest);
        Page<ResidenzaStoricoDTO> results = residenzaStoricoService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
    }

    @Operation(summary = "Aggiorna una Residenza Storico", description = "L'aggiornamento richiede obbligatoriamente l'id della Residenza Storico da aggiornare", tags = { "Residenza Storico Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Residenza Storico aggiornata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Residenza Storico non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @PutMapping()
    public ResponseEntity<ResidenzaStoricoDTO> updateResidenzaStorico(@Validated @RequestBody ResidenzaStoricoUpdateDTO dto) {
        log.debug("REST request to update Residenza Storico: {}", dto);
        return new ResponseEntity<>(residenzaStoricoService.update(dto), HttpStatus.OK);
    }


    @Operation(summary = "Elimina una Residenza Storico", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Residenza Storico Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Residenza Storico eliminata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Residenza Storico non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResidenzaStorico(@PathVariable("id") UUID id) {
        log.debug("REST request to delete Residenza Storico: {}", id);
        residenzaStoricoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
