package com.thanhdong.tuyensinh.repository;

import com.thanhdong.tuyensinh.entity.RegistrationPreferences;
import com.thanhdong.tuyensinh.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistrationPreferencesRepository extends IGenericRepository<RegistrationPreferences, Integer> {

    Optional<List<RegistrationPreferences>>  findByEnrollmentApplicationId(int enrollmentApplicationId);
}
