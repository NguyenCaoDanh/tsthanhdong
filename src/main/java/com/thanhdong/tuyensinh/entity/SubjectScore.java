package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "subject_score", schema = "wisdomenrollment", catalog = "")
public class SubjectScore {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_subject_score", nullable = false)
    private int idSubjectScore;
    @Basic
    @Column(name = "first_semester_score", nullable = false, precision = 2)
    private BigDecimal firstSemesterScore;
    @Basic
    @Column(name = "second_semester_score", nullable = true, precision = 2)
    private BigDecimal secondSemesterScore;
}
