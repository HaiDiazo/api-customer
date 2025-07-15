package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Test Technic Customer API")
                        .version("1.0.2")
                        .description("A API allow CRUD operations user for get data user and customers")
                        .contact(new Contact()
                                .name("Donatelo")
                                .email("nathanaptanta@gmail.com")));
    }
}
