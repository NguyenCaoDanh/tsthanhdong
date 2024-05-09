package com.thanhdong.tuyensinh.service;

import com.thanhdong.tuyensinh.dto.RecruitmentDTO;
import com.thanhdong.tuyensinh.entity.Recruitment;
import com.thanhdong.tuyensinh.generic.IGenericService;

public interface RecruitmentService extends IGenericService<Recruitment> {
    Recruitment createRecruitment(RecruitmentDTO recruitmentDTO);

    Recruitment updateRecruitment(int idRecruitment, RecruitmentDTO recruitmentDTO);
}
