package com.bancojavar.demo_bancojavar_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocOpenApiConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Segunda aplicação - Armazenamento")
                                .description(" Esta aplicação é o coração do nosso sistema de armazenamento. Ela será responsável por realizar operações CRUD em uma base de dados local H2")
                                .version("Versão final.")
                                .contact(new Contact().name("João Ambrósio").email("joao.ambrosio@ibm.com"))
                );
    }
}
