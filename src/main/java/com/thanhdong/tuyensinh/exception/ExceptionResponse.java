package com.thanhdong.tuyensinh.exception;

import lombok.*;

@Data
@NoArgsConstructor
public class ExceptionResponse {
    private final String status = "error";
    private String timestamp;
    private Object message;

    public ExceptionResponse(String timestamp, Object message) {
        this.timestamp = timestamp;
        this.message = message;
    }
}
