package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "academic_results", schema = "wisdomenrollment", catalog = "")
public class AcademicResults {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_academic_results", nullable = false)
    private int idAcademicResults;
    @Basic
    @Column(name = "result_10th_grade", nullable = false)
    private int result10ThGrade;
    @Basic
    @Column(name = "result_11th_grade", nullable = false)
    private int result11ThGrade;
    @Basic
    @Column(name = "result_12th_grade", nullable = false)
    private int result12ThGrade;
    @Basic
    @Column(name = "ielts_info_id", nullable = true)
    private Integer ieltsInfoId;
}
