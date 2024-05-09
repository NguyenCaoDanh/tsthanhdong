package com.thanhdong.tuyensinh.repository;

import com.thanhdong.tuyensinh.entity.Banner;
import com.thanhdong.tuyensinh.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends IGenericRepository<Banner, Integer> {
}
