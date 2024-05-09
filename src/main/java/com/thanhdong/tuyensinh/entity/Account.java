package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@EqualsAndHashCode
public class Account implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_account", nullable = false)
    private int idAccount;
    @Basic
    @Column(name = "email", nullable = false, length = 100)
    private String email;//email đăng nhập, đăng ký
    @Basic
    @Column(name = "password", nullable = false, length = 500)
    private String password;
    @Basic
    @Column(name = "role_id", nullable = false)
    private int roleId;
    @Basic
    @Column(name = "disable", nullable = false)
    private byte disable;
    @Basic
    @Column(name = "OTP",columnDefinition = "varchar(6)",nullable = true)
    private String OTP;
    @Basic
    @Column(name = "update_at", nullable = true)
    private Timestamp updateAt;
}
