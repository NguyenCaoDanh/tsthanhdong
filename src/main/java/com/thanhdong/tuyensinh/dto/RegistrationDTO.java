package com.thanhdong.tuyensinh.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class RegistrationDTO {
    private String firstName;
    private String lastName;
    private String phone;
    private String gender;
    private Date dateOfBirth;
    private String email;
    private String password;
}
