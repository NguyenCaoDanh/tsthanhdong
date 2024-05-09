package com.thanhdong.tuyensinh.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;
import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "citizen_identification", schema = "wisdomenrollment", catalog = "")
public class CitizenIdentification {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_citizen_identification", nullable = false)
    private int idCitizenIdentification;
    @Basic
    @Column(name = "number_citizen_identification", nullable = false, precision = 0)
    private int numberCitizenIdentification;
    @Basic
    @Column(name = "date_of_issue", nullable = false)
    private Date dateOfIssue;
    @Basic
    @Column(name = "place_of_issue", nullable = false, length = 500)
    private String placeOfIssue;
    @Basic
    @Column(name = "place_of_origin", nullable = false, length = 500)
    private String placeOfOrigin;
    @Basic
    @Column(name = "place_of_precidence", nullable = false, length = 500)
    private String placeOfPrecidence;
    @Basic
    @Column(name = "front_of_card", nullable = false, length = 500)
    private String frontOfCard;
    @Basic
    @Column(name = "back_of_card", nullable = false, length = 500)
    private String backOfCard;
}
