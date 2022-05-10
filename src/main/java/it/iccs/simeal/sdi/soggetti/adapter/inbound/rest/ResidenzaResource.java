package it.iccs.simeal.sdi.soggetti.adapter.inbound.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.ResidenzaService;
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
@RequestMapping("/api/residenza")
public class ResidenzaResource {

    @Autowired
    private ResidenzaService residenzaService;

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


    @Operation(summary = "Recupera tutte le Residenze che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Residenza Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Residenza trovata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "204", description = "Nessuna Residenza trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })

    @GetMapping(params = {"ids"})
    public ResponseEntity<List<ResidenzaDTO>> findResidenzaByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
        log.debug("REST request to find any Residenza {}", ids);
        List<ResidenzaDTO> dtos = residenzaService.findByIds(ids);
        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }

    @Operation(summary = "Recupera tutti le Residenze che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Residenza Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Residenza trovata"),
            @ApiResponse(responseCode = "204", description = "Nessuna Residenza trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @GetMapping("/ricerca")
    public ResponseEntity<Page<ResidenzaDTO>> searchResidenza(ResidenzaCriteria criteria, Pageable pageRequest) {
        log.debug("REST request to search Residenza: {} {}", criteria, pageRequest);
        Page<ResidenzaDTO> results = residenzaService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
    }

    @Operation(summary = "Aggiorna una Residenza", description = "L'aggiornamento richiede obbligatoriamente l'id della Residenza da aggiornare", tags = { "Residenza Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "residenza aggiornata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Residenza non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @PutMapping()
    public ResponseEntity<ResidenzaDTO> updateResidenza(@Validated @RequestBody ResidenzaUpdateDTO dto) {
        log.debug("REST request to update Residenza: {}", dto);
        return new ResponseEntity<>(residenzaService.update(dto), HttpStatus.OK);
    }


    @Operation(summary = "Elimina una Residenza", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Residenza Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Residenza eliminata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Residenza non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResidenza(@PathVariable("id") UUID id) {
        log.debug("REST request to delete Residenza: {}", id);
        residenzaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
