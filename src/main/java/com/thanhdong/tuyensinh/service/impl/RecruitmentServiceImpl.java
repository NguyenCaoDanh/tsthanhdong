package com.thanhdong.tuyensinh.service.impl;

import com.thanhdong.tuyensinh.dto.RecruitmentDTO;
import com.thanhdong.tuyensinh.entity.Major;
import com.thanhdong.tuyensinh.entity.Recruitment;
import com.thanhdong.tuyensinh.exception.ErrorHandler;
import com.thanhdong.tuyensinh.repository.MajorRepository;
import com.thanhdong.tuyensinh.repository.RecruitmentRepository;
import com.thanhdong.tuyensinh.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {

    @Autowired
    private RecruitmentRepository recruitmentRepository;
    @Autowired
    private MajorRepository majorRepository;

    @Override
    public void save(Recruitment recruitment) {
        try {
            recruitmentRepository.save(recruitment);
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Recruitment> findAll() {
        return null;
    }

    @Override
    public Recruitment findOne(int id) {
        return null;
    }

    public Recruitment createRecruitment(RecruitmentDTO recruitmentDTO) {
        try {
            Optional<Major> optionalPost = majorRepository.findById(recruitmentDTO.getMajorId());
            if (optionalPost.isPresent()) {
                Recruitment recruitment = new Recruitment();
                recruitment.setDateStart(recruitmentDTO.getDateStart());
                recruitment.setDateEnd(recruitmentDTO.getDateEnd());
                recruitment.setScoreRequirement(recruitmentDTO.getScoreRequirement());
                recruitment.setQuota(recruitmentDTO.getQuota());
                recruitment.setMajorId(recruitmentDTO.getMajorId());
                return recruitmentRepository.save(recruitment);
            } else {
                throw new ErrorHandler("Major not found with id: " + recruitmentDTO.getMajorId());
            }
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    public Recruitment updateRecruitment(int idRecruitment, RecruitmentDTO recruitmentDTO) {
        try {
            Optional<Recruitment> optionalRecruitment = recruitmentRepository.findById(idRecruitment);
            if (optionalRecruitment.isPresent()) {
                Optional<Major> optionalPost = majorRepository.findById(recruitmentDTO.getMajorId());
                if (optionalPost.isPresent()) {
                    Recruitment recruitment = new Recruitment();
                    recruitment.setIdRecruitment(idRecruitment);
                    recruitment.setDateStart(recruitmentDTO.getDateStart());
                    recruitment.setDateEnd(recruitmentDTO.getDateEnd());
                    recruitment.setScoreRequirement(recruitmentDTO.getScoreRequirement());
                    recruitment.setQuota(recruitmentDTO.getQuota());
                    recruitment.setMajorId(recruitmentDTO.getMajorId());
                    return recruitmentRepository.save(recruitment);
                } else {
                    throw new ErrorHandler("Major not found with id: " + recruitmentDTO.getMajorId());
                }
            } else {
                throw new ErrorHandler("Recruitment not found with ID: " + idRecruitment);
            }
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }


}
