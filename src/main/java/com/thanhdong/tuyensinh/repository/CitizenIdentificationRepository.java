package com.thanhdong.tuyensinh.repository;

import com.thanhdong.tuyensinh.entity.CitizenIdentification;
import com.thanhdong.tuyensinh.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenIdentificationRepository extends IGenericRepository<CitizenIdentification, Integer> {
}
