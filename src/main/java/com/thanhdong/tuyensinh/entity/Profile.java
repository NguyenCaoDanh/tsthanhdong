package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;
import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
public class Profile {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_profile", nullable = false)
    private int idProfile;
    @Basic
    @Column(name = "first_name", nullable = false, length = 500)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = true, length = 500)
    private String lastName;
    @Basic
    @Column(name = "phone", nullable = true, length = 500)
    private String phone;
    @Basic
    @Column(name = "gender", nullable = true, length = 500)
    private String gender;
    @Basic
    @Column(name = "date_of_birth", nullable = true)
    private Date dateOfBirth;
    @Basic
    @Column(name = "account_id", nullable = true)
    private Integer accountId;
    @Basic
    @Column(name = "email", nullable = false, length = 500)
    private String email;
}
