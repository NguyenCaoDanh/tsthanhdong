package com.thanhdong.tuyensinh.repository;

import com.thanhdong.tuyensinh.entity.EnrollmentApplication;
import com.thanhdong.tuyensinh.generic.IGenericRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public interface EnrollmentApplicationRepository extends IGenericRepository<EnrollmentApplication, Integer> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "UPDATE enrollment_application " +
                    "SET enrollment_application_status_id = :enrollmentApplicationStatusId " +
                    "WHERE id_enrollment_application = :enrollmentApplicationId ")
    int approval(int enrollmentApplicationId, int enrollmentApplicationStatusId);

    @Query(nativeQuery = true,
            value = "SELECT * " +
                    "FROM enrollment_application ea " +
                    "WHERE ea.id_enrollment_application = :enrollmentApplicationId ")
    EnrollmentApplication getDetail(int enrollmentApplicationId);

    Optional<EnrollmentApplication> findByProfileId(int profileId);
}
