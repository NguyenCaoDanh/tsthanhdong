package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "specialized_class", schema = "wisdomenrollment", catalog = "")
public class SpecializedClass {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_specialized_class", nullable = false)
    private int idSpecializedClass;
    @Basic
    @Column(name = "specialized_class", nullable = false, length = 100)
    private String specializedClass;
}
