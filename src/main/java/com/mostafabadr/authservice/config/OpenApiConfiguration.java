package com.mostafabadr.authservice.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
  @Bean
  OpenAPI openAPI() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Auth Service API")
                .description(
                    "Authentication and Authorization microservice built with Spring Boot.")
                .version("v1")
                .contact(
                    new Contact()
                        .name("Mostafa Badr")
                        .url("https://www.linkedin.com/in/mostafa-badr-221224135/")
                        .email("mostafabadr664@gmail.com"))
                .license(
                    new License().name("MIT License").url("https://opensource.org/licenses/MIT")))
        .externalDocs(
            new ExternalDocumentation()
                .description("Project Repository")
                .url("https://github.com/MoustafaBadr/auth-service"));
  }
}
