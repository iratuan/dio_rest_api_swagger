package br.com.dio.api.config.swagger;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;

// Define a configuration class for Swagger
@Configuration
public class SwaggerConfig {

    // Create a bean for the public API
    @Bean
    // Use GroupedOpenApi to define an open API group for public APIs
    public GroupedOpenApi publicApi() {
        // Builder pattern to create the GroupedOpenApi instance
        return GroupedOpenApi.builder()
                // Set the group name to "public-apis"
                .group("public-apis")
                // Define paths to match (/**)
                .pathsToMatch("/**")
                // Build the GroupedOpenApi instance
                .build();
    }

    // Create a bean for the custom OpenAPI
    @Bean
    public OpenAPI customOpenApi() {

        // Define an info object to hold metadata about the API
        io.swagger.v3.oas.models.info.Contact contact = new io.swagger.v3.oas.models.info.Contact();
        // Set the name of the contact person
        contact.setName("Iratuan Junior");
        // Set the email address of the contact person
        contact.setEmail("iratuan@gmail.com");
        // Set the URL of the contact person
        contact.setUrl("http://iratuan.com.br");

        // Create an instance of OpenAPI with custom metadata and security settings
        return new OpenAPI()
                // Define info object for API metadata (title, version, contact)
                .info(new Info().title("API DEMO REST AND SWAGGER")
                        // Set the API title
                        .version("API VERSION 1.0")
                        // Add contact information to the info object
                        .contact(contact))
                // Add a security requirement for bearer authentication
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                // Define components, including security schemes and others
                .components(new Components()
                        // Add a security scheme with type HTTP and scheme "bearer"
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                // Set the security scheme type to HTTP
                                .type(Type.HTTP)
                                // Set the scheme for the security scheme
                                .scheme("bearer")
                                // Set the bearer format (in this case, JWT)
                                .bearerFormat("JWT")));

    }
}
