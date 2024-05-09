package com.thanhdong.tuyensinh.repository;


import com.thanhdong.tuyensinh.entity.Recruitment;
import com.thanhdong.tuyensinh.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitmentRepository extends IGenericRepository<Recruitment, Integer> {
}
