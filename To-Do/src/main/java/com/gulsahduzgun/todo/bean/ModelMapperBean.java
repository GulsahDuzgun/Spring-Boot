package com.gulsahduzgun.todo.bean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//ModelMapperBean makes DTO -> Entity  and  Entity-> DTO convertation

@Configuration
public class ModelMapperBean {
    @Bean
    public ModelMapper getModelMapperMethod() {
        return  new ModelMapper();
    }
}
