package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
public class Major {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_major", nullable = false)
    private int idMajor;
    @Basic
    @Column(name = "name_major", nullable = false, length = 500)
    private String nameMajor;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "faculty_id", nullable = false)
    private int facultyId;
    @Basic
    @Column(name = "training_program_id", nullable = false)
    private int trainingProgramId;
}
