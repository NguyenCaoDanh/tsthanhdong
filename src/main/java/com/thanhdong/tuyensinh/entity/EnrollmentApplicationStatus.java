package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "enrollment_application_status", schema = "wisdomenrollment", catalog = "")
public class EnrollmentApplicationStatus {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_enrollment_application_status", nullable = false)
    private int idEnrollmentApplicationStatus;
    @Basic
    @Column(name = "enrollment_application_status", nullable = false, length = 45)
    private String enrollmentApplicationStatus;
}
