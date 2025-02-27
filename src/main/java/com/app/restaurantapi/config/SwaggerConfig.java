package com.app.restaurantapi.config;

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
                        .title("Rústica API")
                        .version("1.0")
                        .description("Documentación del API para la gestión de productos y ventas para la aplicacion android de Rústica")
                );
    }
}
