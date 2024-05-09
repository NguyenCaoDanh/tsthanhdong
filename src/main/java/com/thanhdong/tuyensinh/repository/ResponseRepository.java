package com.thanhdong.tuyensinh.repository;

import com.thanhdong.tuyensinh.entity.Response;
import com.thanhdong.tuyensinh.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends IGenericRepository<Response, Integer> {
}
