package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "training_program", schema = "wisdomenrollment", catalog = "")
public class TrainingProgram {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_training_program", nullable = false)
    private int idTrainingProgram;
    @Basic
    @Column(name = "name_training_program", nullable = false, length = 500)
    private String nameTrainingProgram;
    @Basic
    @Column(name = "description", nullable = true, length = 500)
    private String description;
}
