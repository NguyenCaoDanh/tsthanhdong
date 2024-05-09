package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
public class Faculty {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_faculty", nullable = false)
    private int idFaculty;
    @Basic
    @Column(name = "name_faculty", nullable = false, length = 500)
    private String nameFaculty;
    @Basic
    @Column(name = "description", nullable = true, length = 500)
    private String description;
}
