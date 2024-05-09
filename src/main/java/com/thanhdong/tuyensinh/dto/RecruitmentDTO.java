package com.thanhdong.tuyensinh.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;


@Getter
@Setter
public class RecruitmentDTO {
    private Date dateStart;
    private Date dateEnd;
    private BigDecimal scoreRequirement;
    private int quota;
    private int majorId;
}
