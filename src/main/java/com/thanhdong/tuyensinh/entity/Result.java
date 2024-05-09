package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
public class Result {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_result", nullable = false)
    private int idResult;
    @Basic
    @Column(name = "grade_transcript_picture", nullable = false, length = 500)
    private String gradeTranscriptPicture;
    @Basic
    @Column(name = "math_id", nullable = false)
    private int mathId;
    @Basic
    @Column(name = "physics_id", nullable = false)
    private int physicsId;
    @Basic
    @Column(name = "chemistry_id", nullable = false)
    private int chemistryId;
    @Basic
    @Column(name = "biology_id", nullable = false)
    private int biologyId;
    @Basic
    @Column(name = "literature_id", nullable = false)
    private int literatureId;
    @Basic
    @Column(name = "history_id", nullable = false)
    private int historyId;
    @Basic
    @Column(name = "geography_id", nullable = false)
    private int geographyId;
    @Basic
    @Column(name = "foreign_language_id", nullable = false)
    private int foreignLanguageId;
    @Basic
    @Column(name = "civic_education_id", nullable = false)
    private int civicEducationId;
}
