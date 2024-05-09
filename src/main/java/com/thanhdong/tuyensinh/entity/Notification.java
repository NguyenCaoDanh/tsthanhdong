package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
public class Notification {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_notification", nullable = false)
    private int idNotification;
    @Basic
    @Column(name = "title_notification", nullable = false, length = 500)
    private String titleNotification;
    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;
    @Basic
    @Column(name = "send_time", nullable = false)
    private Timestamp sendTime;
    @Basic
    @Column(name = "profile_id", nullable = false)
    private int profileId;
}
