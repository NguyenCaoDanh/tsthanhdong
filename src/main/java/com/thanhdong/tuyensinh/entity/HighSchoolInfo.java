package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "high_school_info", schema = "wisdomenrollment", catalog = "")
public class HighSchoolInfo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_high_school_info", nullable = false)
    private int idHighSchoolInfo;
    @Basic
    @Column(name = "high_school_1_id", nullable = false)
    private int highSchool1Id;
    @Basic
    @Column(name = "high_school_2_id", nullable = false)
    private int highSchool2Id;
    @Basic
    @Column(name = "high_school_3_id", nullable = false)
    private int highSchool3Id;
    @Basic
    @Column(name = "priority_population_id", nullable = false)
    private int priorityPopulationId;
    @Basic
    @Column(name = "specialized_class_id", nullable = true)
    private Integer specializedClassId;
}
