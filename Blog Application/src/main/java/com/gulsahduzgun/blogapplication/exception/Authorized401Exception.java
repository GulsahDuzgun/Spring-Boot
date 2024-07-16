package com.gulsahduzgun.blogapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class Authorized401Exception extends RuntimeException{
    public Authorized401Exception (String message) {
        super(message);
    }
}
