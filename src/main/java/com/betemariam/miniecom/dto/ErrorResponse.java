package com.betemariam.miniecom.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    // Getters (no setters for immutability)
    private final String code;
    private final String message;
    private final int status;
    private final Instant timestamp;

    // Constructor
    public ErrorResponse(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.status = httpStatus.value();
        this.timestamp = Instant.now();
    }

}
