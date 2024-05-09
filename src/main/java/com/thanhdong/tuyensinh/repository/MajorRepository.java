package com.thanhdong.tuyensinh.repository;

import com.thanhdong.tuyensinh.entity.Major;
import com.thanhdong.tuyensinh.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorRepository extends IGenericRepository<Major, Integer> {
}
