package com.gulsahduzgun.todo.bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerBean {

    @Bean
    public OpenAPI getOpenAPIMethod() {
        return  new OpenAPI().info(new Info()
                .title("To-Do List")
                .version("v1.0.0")
                .description("Spring Boot & React.js")
                .summary("To-Do List, auth: "+hashCode())
                .description("To-Do List Application")
                .termsOfService(" Software INC")
                .contact(new Contact()
                        .name("Gülşah Düzgün")
                        .email("test@gmail.com")
                        .url("https://github.com/GulsahDuzgun")
                )
                .license(new License()
                        .name("licence INC xyz")
                        .url("https://github.com/GulsahDuzgun")
                )
        );
    }
}
