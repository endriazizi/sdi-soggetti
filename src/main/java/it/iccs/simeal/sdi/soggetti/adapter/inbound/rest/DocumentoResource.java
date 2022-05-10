package it.iccs.simeal.sdi.soggetti.adapter.inbound.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.DocumentoService;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.DocumentoService;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.DocumentoService;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.*;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DocumentoCreateDTO;
import it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model.DocumentoDTO;
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
@RequestMapping("/api/documento")
public class DocumentoResource {

    @Autowired
    private DocumentoService documentoService;

    @Autowired
    private DocumentoService domandaService;

    @Operation(summary = "Crea una Documento", description = "La creazione non richiede campi obbligatori", tags = { "Documento Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Documento Soggetto creato", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @PostMapping
    public ResponseEntity<DocumentoDTO> createDocumento(@Validated @RequestBody DocumentoCreateDTO dto) {
        log.debug("REST request to create Documento: {}", dto);
        return new ResponseEntity<>(documentoService.create(dto), HttpStatus.OK);
    }

 

    @Operation(summary = "Recupera tutte le Documenti che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Documento Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Documento trovata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "204", description = "Nessuna Documento trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })

    @GetMapping(params = {"ids"})
    public ResponseEntity<List<DocumentoDTO>> findDocumentoByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
        log.debug("REST request to find any Documento {}", ids);
        List<DocumentoDTO> dtos = documentoService.findByIds(ids);
        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }

    @Operation(summary = "Recupera tutti le Documenti che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Documento Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Documento trovata"),
            @ApiResponse(responseCode = "204", description = "Nessuna Documento trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @GetMapping("/ricerca")
    public ResponseEntity<Page<DocumentoDTO>> searchDocumento(DocumentoCriteria criteria, Pageable pageRequest) {
        log.debug("REST request to search Documento: {} {}", criteria, pageRequest);
        Page<DocumentoDTO> results = documentoService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
    }

    @Operation(summary = "Aggiorna una Documento", description = "L'aggiornamento richiede obbligatoriamente l'id della Documento da aggiornare", tags = { "Documento Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Documento aggiornata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Documento non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @PutMapping()
    public ResponseEntity<DocumentoDTO> updateDocumento(@Validated @RequestBody DocumentoUpdateDTO dto) {
        log.debug("REST request to update Documento: {}", dto);
        return new ResponseEntity<>(documentoService.update(dto), HttpStatus.OK);
    }


    @Operation(summary = "Elimina una Documento", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Documento Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Documento eliminata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Documento non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDocumento(@PathVariable("id") UUID id) {
        log.debug("REST request to delete Documento: {}", id);
        documentoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
