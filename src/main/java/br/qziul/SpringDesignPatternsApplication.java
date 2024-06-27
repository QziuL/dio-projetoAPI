package br.qziul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * 	API com Spring Boot para cadastro de pessoa com seu respectivo endereço (CEP).
 * 	Projeto gerado via Spring Initializr.
 * 	Os seguintes módulos foram selecionados:
 *   - Spring Data JPA
 *   - Spring Web
 *   - H2Database
 *   - OpenFeign
 *
 * 	@autor QziuL(Github)
 */
@EnableFeignClients
@SpringBootApplication
public class SpringDesignPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDesignPatternsApplication.class, args);
	}


}
