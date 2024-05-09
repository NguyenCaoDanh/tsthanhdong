package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "major_has_subject_combination", schema = "wisdomenrollment", catalog = "")
public class MajorHasSubjectCombination {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "major_has_subject_combination", nullable = false)
    private int majorHasSubjectCombination;
    @Basic
    @Column(name = "major_id", nullable = false)
    private int majorId;
    @Basic
    @Column(name = "subject_combination_id", nullable = false)
    private int subjectCombinationId;
}
