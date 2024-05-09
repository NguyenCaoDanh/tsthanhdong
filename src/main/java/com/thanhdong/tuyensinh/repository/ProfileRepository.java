package com.thanhdong.tuyensinh.repository;

import com.thanhdong.tuyensinh.entity.Profile;
import com.thanhdong.tuyensinh.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends IGenericRepository<Profile, Integer> {
    Optional<Profile> findByEmail(String email);
    Optional<Profile> findByAccountId(int accountId);
//    Profile findByEmail(String email);
}
