package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "subject_combination_has_subject", schema = "wisdomenrollment", catalog = "")
public class SubjectCombinationHasSubject {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_subject_combination_has_subject", nullable = false)
    private int idSubjectCombinationHasSubject;
    @Basic
    @Column(name = "subject_combination_id", nullable = false)
    private int subjectCombinationId;
    @Basic
    @Column(name = "subject_id", nullable = false)
    private int subjectId;
}
