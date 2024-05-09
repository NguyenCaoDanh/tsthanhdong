package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
public class Province {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_province", nullable = false)
    private int idProvince;
    @Basic
    @Column(name = "province", nullable = false, length = 500)
    private String province;
    @Basic
    @Column(name = "administrative_levels_id", nullable = false)
    private int administrativeLevelsId;
}
