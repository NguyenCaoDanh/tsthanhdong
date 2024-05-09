package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "specialized_subject", schema = "wisdomenrollment", catalog = "")
public class SpecializedSubject {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_specialized_subject", nullable = false)
    private int idSpecializedSubject;
    @Basic
    @Column(name = "name_specialized_subject", nullable = false, length = 85)
    private String nameSpecializedSubject;
    @Basic
    @Column(name = "certificate", nullable = false, length = 500)
    private String certificate;
    @Basic
    @Column(name = "award_ranking_id", nullable = false)
    private int awardRankingId;
}
