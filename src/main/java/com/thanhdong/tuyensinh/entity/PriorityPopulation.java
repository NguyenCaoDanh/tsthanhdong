package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "priority_population", schema = "wisdomenrollment", catalog = "")
public class PriorityPopulation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_priority_population", nullable = false)
    private int idPriorityPopulation;
    @Basic
    @Column(name = "priority_population", nullable = false, length = 500)
    private String priorityPopulation;
}
