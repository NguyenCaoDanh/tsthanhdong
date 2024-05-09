package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "subject_combination", schema = "wisdomenrollment", catalog = "")
public class SubjectCombination {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_subject_combination", nullable = false)
    private int idSubjectCombination;
    @Basic
    @Column(name = "name_subject_combination", nullable = false, length = 45)
    private String nameSubjectCombination;
}
