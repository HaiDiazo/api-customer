package com.example.demo.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseApi<T> {
    private int statusCode;
    private double timeExecution;
    private T data;

    public ResponseApi(int statusCode, double timeExecution, T data) {
        this.statusCode = statusCode;
        this.timeExecution = timeExecution;
        this.data = data;
    }
}
