package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "award_ranking", schema = "wisdomenrollment", catalog = "")
public class AwardRanking {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_award_ranking", nullable = false)
    private int idAwardRanking;
    @Basic
    @Column(name = "award_ranking", nullable = false, length = 95)
    private String awardRanking;
}
