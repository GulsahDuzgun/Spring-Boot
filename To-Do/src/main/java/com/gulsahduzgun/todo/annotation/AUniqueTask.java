package com.gulsahduzgun.todo.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


    @Target({ ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = {UniqueTaskStatusValidation.class})
    public @interface AUniqueTask {
        String message() default "{task.status.unique.validation.constraints.NotNull.message}";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
}

