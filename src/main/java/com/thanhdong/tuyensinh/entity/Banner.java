package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;
import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
public class Banner {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_banner", nullable = false)
    private int idBanner;
    @Basic
    @Column(name = "link_banner", nullable = false, length = 500)
    private String linkBanner;
    @Basic
    @Column(name = "date_add", nullable = false)
    private Date dateAdd;
    @Basic
    @Column(name = "date_end", nullable = false)
    private Date dateEnd;
    @Basic
    @Column(name = "poster_id", nullable = true)
    private Integer posterId;
}
