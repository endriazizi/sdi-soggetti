package it.iccs.simeal.sdi.soggetti.application.port.outbound.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@FeignClient(value="Tabelle",url="http://localhost:8091/api/")
public interface TabelleClient {

    @GetMapping("stato-domanda/esiste")
    Boolean checkStatoDomandaExists(@NotNull @RequestParam(value = "id") UUID idstatodomanda);

    @GetMapping("istituto/esiste")
    Boolean checkIstitutoExists(@NotNull @RequestParam(value = "id") UUID idistituto);

    @GetMapping("classe/esiste")
    Boolean checkClasseExists(@NotNull @RequestParam(value = "id") UUID idclasse);

    @GetMapping("sezione/esiste")
    Boolean checkSezioneExists(@NotNull @RequestParam(value = "id") UUID idsezione);
}
