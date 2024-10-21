package br.com.dio.api.config.swagger;

import java.util.Arrays;
import java.util.HashSet;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;

@Configuration
public class SwaggerConfig {

    @Bean
    GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-apis")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    OpenAPI customOpenApi() {

        io.swagger.v3.oas.models.info.Contact contact = new io.swagger.v3.oas.models.info.Contact();
        contact.setName("Iratuan Junior");
        contact.setEmail("iratuan@gmail.com");
        contact.setUrl("http://iratuan.com.br");

        return new OpenAPI()
                .info(new Info().title("API DEMO REST AND SWAGGER")
                        .version("API VERSION 1.0")
                        .contact(contact))
                        .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                        .components( new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                        .type(Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")));
    }
}
