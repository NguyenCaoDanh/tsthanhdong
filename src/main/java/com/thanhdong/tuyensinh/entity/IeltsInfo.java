package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "ielts_info", schema = "wisdomenrollment", catalog = "")
public class IeltsInfo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_ielts_info", nullable = false)
    private int idIeltsInfo;
    @Basic
    @Column(name = "certificate", nullable = false, length = 500)
    private String certificate;
    @Basic
    @Column(name = "score", nullable = false, precision = 2)
    private BigDecimal score;
}
