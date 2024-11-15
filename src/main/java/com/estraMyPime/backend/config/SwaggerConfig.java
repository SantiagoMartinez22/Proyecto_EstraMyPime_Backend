package com.estraMyPime.backend.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Documentación de la API EstraMypime parte backend")
                        .version("1.0.0")
                        .description("Documentación generada para la RestApi exponiendo sus endpoints y distintos request posibles"));
    }
}

