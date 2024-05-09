package com.thanhdong.tuyensinh.model.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OTPRequest {
    private String email;
    private String subject;

}
