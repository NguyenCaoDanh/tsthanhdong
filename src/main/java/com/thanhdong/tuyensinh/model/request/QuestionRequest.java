package com.thanhdong.tuyensinh.model.request;

import lombok.Data;

@Data
public class QuestionRequest {
    private String email;
    private String firstName;
    private String content;
}
