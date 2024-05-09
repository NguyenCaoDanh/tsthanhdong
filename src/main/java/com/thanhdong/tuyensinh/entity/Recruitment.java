package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
public class Recruitment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_recruitment", nullable = false)
    private int idRecruitment;
    @Basic
    @Column(name = "date_start", nullable = false)
    private Date dateStart;
    @Basic
    @Column(name = "date_end", nullable = false)
    private Date dateEnd;
    @Basic
    @Column(name = "score_requirement", nullable = false, precision = 2)
    private BigDecimal scoreRequirement;
    @Basic
    @Column(name = "quota", nullable = false)
    private int quota;
    @Basic
    @Column(name = "major_id", nullable = false)
    private int majorId;
}
