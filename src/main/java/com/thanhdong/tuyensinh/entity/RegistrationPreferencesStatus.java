package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "registration_preferences_status", schema = "wisdomenrollment", catalog = "")
public class RegistrationPreferencesStatus {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_registration_preferences_status", nullable = false)
    private int idRegistrationPreferencesStatus;
    @Basic
    @Column(name = "rp_status", nullable = false, length = 45)
    private String rpStatus;
}
