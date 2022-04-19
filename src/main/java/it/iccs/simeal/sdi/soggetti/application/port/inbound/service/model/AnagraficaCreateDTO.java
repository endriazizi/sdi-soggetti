package it.iccs.simeal.sdi.soggetti.application.port.inbound.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
//@NoArgsConstructor
//@AllArgsConstructor
public class AnagraficaCreateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id;

	private String tipologiaSoggetto;

	private String denominazione;

	private String cognome;

	private String nome;

	private LocalDate dataNascita;

	private String localitaNascita;

	private String provinciaNascita;

	private String codiceFiscale;

	private String sesso;

	private String note;

}
