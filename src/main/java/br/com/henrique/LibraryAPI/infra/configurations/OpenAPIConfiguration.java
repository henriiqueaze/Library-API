package br.com.henrique.LibraryAPI.infra.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Library-API")
                .version("V1")
                .description("API to manage and organize book data, including adding, updating, retrieving, and deleting books.")
                .termsOfService("https://henriiqueaze.github.io/Portfolio-Henrique/")
                .license(new License()
                        .name("MIT License")
                        .url("https://github.com/henriiqueaze/Library-API?tab=MIT-1-ov-file")));
    }
}
