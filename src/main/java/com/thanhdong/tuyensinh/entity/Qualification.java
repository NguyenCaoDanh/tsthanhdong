package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
public class Qualification {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_qualification", nullable = false)
    private int idQualification;
    @Basic
    @Column(name = "qualification", nullable = false, length = 500)
    private String qualification;
    @Basic
    @Column(name = "qualification_picture", nullable = false, length = 500)
    private String qualificationPicture;
}
