package com.gulsahduzgun.blogapplication.bean;

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
                .title("Advanced Fullstack Mastery Bootcamp by Hamit Mızrak")
                .version("v1.0.0")
                .description("Spring Boot & React.js")
                .summary(" for spring boot on react js, auth: "+hashCode())
                .description("Spring Boot & React Js & Devops")
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
