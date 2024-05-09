package com.thanhdong.tuyensinh.repository;

import com.thanhdong.tuyensinh.entity.Faculty;
import com.thanhdong.tuyensinh.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends IGenericRepository<Faculty, Integer> {
}
