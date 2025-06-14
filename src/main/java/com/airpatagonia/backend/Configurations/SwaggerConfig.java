package com.airpatagonia.backend.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Air Patagonia API")
                        .version("1.0.0")
                        .description("API para el sistema de gestión de vuelos de Air Patagonia")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo")
                                .email("desarrollo@airpatagonia.com")
                                .url("https://airpatagonia.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Servidor de Desarrollo"),
                        new Server().url("https://api.airpatagonia.com").description("Servidor de Producción")));
    }
}