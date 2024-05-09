package com.thanhdong.tuyensinh.repository;

import com.thanhdong.tuyensinh.entity.Qualification;
import com.thanhdong.tuyensinh.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationRepository extends IGenericRepository<Qualification, Integer> {
}
