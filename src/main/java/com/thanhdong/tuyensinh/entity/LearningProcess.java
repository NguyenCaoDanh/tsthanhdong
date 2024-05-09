package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "learning_process", schema = "wisdomenrollment", catalog = "")
public class LearningProcess {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_learning_process", nullable = false)
    private int idLearningProcess;
    @Basic
    @Column(name = "high_school_info_id", nullable = false)
    private int highSchoolInfoId;
    @Basic
    @Column(name = "academic_results_id", nullable = false)
    private int academicResultsId;
    @Basic
    @Column(name = "year_high_school_info", nullable = false)
    private int yearHighSchoolInfo;
    @Basic
    @Column(name = "specialized_subject_id", nullable = true)
    private Integer specializedSubjectId;
}
