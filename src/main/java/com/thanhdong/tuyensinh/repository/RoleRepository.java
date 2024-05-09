package com.thanhdong.tuyensinh.repository;

import com.thanhdong.tuyensinh.entity.Role;
import com.thanhdong.tuyensinh.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends IGenericRepository<Role, Integer> {
}
