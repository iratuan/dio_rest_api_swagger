package br.com.dio.api.handler;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class ResponseError {

    private LocalDateTime timestamp = LocalDateTime.now();
    private String status = "error";
    private int statusCode = 400;
    private String error;

}
