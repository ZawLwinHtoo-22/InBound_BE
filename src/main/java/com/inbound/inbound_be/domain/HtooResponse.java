package com.inbound.inbound_be.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Getter
@Setter
public class HtooResponse<R> {

    private String message;
    private HttpStatus httpStatus;
    private int httpStatusCode;
    private LocalDateTime date;
    private R data;

    public HtooResponse(R data, String message, HttpStatus status){
        this.data = data;
        this.message = message;
        this.httpStatus = status;
        this.httpStatusCode = status.value();
        this.date = LocalDateTime.now();
    }
}
