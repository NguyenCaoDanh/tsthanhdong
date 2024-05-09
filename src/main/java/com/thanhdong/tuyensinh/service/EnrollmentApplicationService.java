package com.thanhdong.tuyensinh.service;

import com.thanhdong.tuyensinh.entity.EnrollmentApplication;
import com.thanhdong.tuyensinh.generic.IGenericService;
import com.thanhdong.tuyensinh.model.request.EnrollmentApplicationRequest;

public interface EnrollmentApplicationService extends IGenericService<EnrollmentApplication> {
    void createEnrollmentApplication(EnrollmentApplicationRequest request);

    EnrollmentApplication updateEnrollmentApplication(int id, EnrollmentApplicationRequest request);

    EnrollmentApplication approval(int enrollmentApplicationId, int enrollmentApplicationStatusId);
}
