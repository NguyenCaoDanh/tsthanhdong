package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
public class Post {
    @Basic
    @Column(name = "image", nullable = true, length = 500)
    private String image;
    @Basic
    @Column(name = "content", nullable = false, length = -1)
    private String content;
    @Basic
    @Column(name = "other", nullable = true, length = 500)
    private String other;
    @Basic
    @Column(name = "faculty_id", nullable = true)
    private Integer facultyId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_post", nullable = false)
    private int idPost;
    @Basic
    @Column(name = "name_post", nullable = false, length = 500)
    private String namePost;
    @Basic
    @Column(name = "disable", nullable = false)
    private byte disable;
}
