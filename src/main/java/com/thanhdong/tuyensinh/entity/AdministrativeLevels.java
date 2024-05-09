package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "administrative_levels", schema = "wisdomenrollment", catalog = "")
public class AdministrativeLevels {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_administrative_levels", nullable = false)
    private int idAdministrativeLevels;
    @Basic
    @Column(name = "administrative_levels", nullable = false, length = 85)
    private String administrativeLevels;
}
