package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
public class District {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_district", nullable = false)
    private int idDistrict;
    @Basic
    @Column(name = "district", nullable = false, length = 85)
    private String district;
    @Basic
    @Column(name = "province_id", nullable = false)
    private int provinceId;
    @Basic
    @Column(name = "administrative_levels_id", nullable = false)
    private int administrativeLevelsId;
}
