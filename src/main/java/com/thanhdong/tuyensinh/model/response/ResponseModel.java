package com.thanhdong.tuyensinh.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseModel {
    private String status;
    private String timestamp;
    private Object data;
}
