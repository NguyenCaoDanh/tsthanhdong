package com.thanhdong.tuyensinh.repository;

import com.thanhdong.tuyensinh.entity.District;
import com.thanhdong.tuyensinh.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DistrictRepository extends IGenericRepository<District, Integer> {
    List<District> findByProvinceId(int provinceId);
}
