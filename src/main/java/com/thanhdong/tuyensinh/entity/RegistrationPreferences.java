package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "registration_preferences", schema = "wisdomenrollment", catalog = "")
public class RegistrationPreferences {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_registration_preferences", nullable = false)
    private int idRegistrationPreferences;
    @Basic
    @Column(name = "recruitment_id", nullable = false)
    private int recruitmentId;
    @Basic
    @Column(name = "enrollment_application_id", nullable = false)
    private int enrollmentApplicationId;
    @Basic
    @Column(name = "priority_level", nullable = false)
    private int priorityLevel;
    @Basic
    @Column(name = "registration_preferences_status_id", nullable = false)
    private int registrationPreferencesStatusId;
}
