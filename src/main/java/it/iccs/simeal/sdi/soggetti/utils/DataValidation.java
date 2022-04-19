package it.iccs.simeal.sdi.soggetti.utils;

import it.iccs.simeal.sdi.soggetti.web.rest.errors.BadRequestException;

import java.time.LocalDate;

public class DataValidation {
	
	public void validatePeriod(LocalDate dataInizio, LocalDate dataFine) {
		if (dataFine != null) {
			if (dataFine.compareTo(dataInizio) <= 0) {
				throw new BadRequestException("La data 'dataFine' deve essere maggiore della data 'dataInizio'");
			}
		}
	}
}
