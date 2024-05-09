package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
public class Response {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_response", nullable = false)
    private int idResponse;
    @Basic
    @Column(name = "question_id", nullable = false)
    private int questionId;
    @Basic
    @Column(name = "content", nullable = false, length = -1)
    private String content;
    @Basic
    @Column(name = "create_time", nullable = false)
    private Timestamp createTime;
    @Basic
    @Column(name = "responser_id", nullable = false)
    private int responserId;
}
