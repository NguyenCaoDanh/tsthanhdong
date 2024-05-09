package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;
import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "enrollment_application", schema = "wisdomenrollment", catalog = "")
public class EnrollmentApplication {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_enrollment_application", nullable = false)
    private int idEnrollmentApplication;
    @Basic
    @Column(name = "full_name", nullable = false, length = 500)
    private String fullName;
    @Basic
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
    @Basic
    @Column(name = "place_of_birth", nullable = false, length = 500)
    private String placeOfBirth;
    @Basic
    @Column(name = "gender", nullable = false, length = 45)
    private String gender;
    @Basic
    @Column(name = "email", nullable = false, length = 500)
    private String email;
    @Basic
    @Column(name = "phone", nullable = false, length = 500)
    private String phone;
    @Basic
    @Column(name = "address", nullable = false, length = 500)
    private String address;
    @Basic
    @Column(name = "citizen_identification_id", nullable = false)
    private int citizenIdentificationId;
    @Basic
    @Column(name = "learning_process_id", nullable = true)
    private int learningProcessId;
    @Basic
    @Column(name = "qualification_id", nullable = false)
    private int qualificationId;
    @Basic
    @Column(name = "profile_id", nullable = false)
    private int profileId;
    @Basic
    @Column(name = "enrollment_application_status_id", nullable = false)
    private int enrollmentApplicationStatusId;
}
