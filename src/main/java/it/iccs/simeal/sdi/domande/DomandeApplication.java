package it.iccs.simeal.sdi.domande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DomandeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomandeApplication.class, args);
	}

}
