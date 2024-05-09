package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "high_school_each", schema = "wisdomenrollment", catalog = "")
public class HighSchoolEach {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_high_school", nullable = false)
    private int idHighSchool;
    @Basic
    @Column(name = "name_high_school", nullable = false, length = 500)
    private String nameHighSchool;
    @Basic
    @Column(name = "district_id_district", nullable = false)
    private int districtIdDistrict;
}
