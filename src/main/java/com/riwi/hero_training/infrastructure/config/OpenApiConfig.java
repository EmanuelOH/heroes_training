package com.riwi.hero_training.infrastructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Hero training api",
        version = "1.0",
        description = "API for skill and mission management in Hero Training"
        //contact = @Contact(name = "Soporte", email = "example@example.com")
),
    servers = {
            //@Server(url = "https://api.herotraining.com/v1", description = "Server of production"),
            @Server(url = "http://localhost:8080", description = "Server local")
    }
)
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenApi(){

        return new OpenAPI()
                .components(
                        new Components().addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .name("Authorization")));

        /*return new OpenAPI()
                .components(new Components()  // Seccion de componentes del OpenAPi
                        .addSecuritySchemes("bearerAuth", // Esquema de seguridad del JWT
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP) //Tipo de esquema: HTTP
                                        .scheme("bearer") //Esquema: bearer
                                        .bearerFormat("JWT") // Formato del token: JWT
                                        .name("AUTHORIZATION"))
                )
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth")) //Requiere el esquema de seguridad en la api
                .info(new io.swagger.v3.oas.models.info.Info() //Informacion adicional de la API
                        .title("Hero Training API") //Titulo de la api
                        .version("1.0") //Version de la API
                        .description("API for the management of skills and missions")

                );*/
    }
}
