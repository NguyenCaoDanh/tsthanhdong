package com.thanhdong.tuyensinh.controller;

import com.thanhdong.tuyensinh.entity.EnrollmentApplication;
import com.thanhdong.tuyensinh.exception.ErrorHandler;
import com.thanhdong.tuyensinh.generic.GenericController;
import com.thanhdong.tuyensinh.jwt.JwtService;
import com.thanhdong.tuyensinh.model.request.EnrollmentApplicationRequest;
import com.thanhdong.tuyensinh.model.response.ResponseModel;
import com.thanhdong.tuyensinh.service.EnrollmentApplicationService;
import com.thanhdong.tuyensinh.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/enrollment_application")
public class EnrollmentApplicationController extends GenericController<EnrollmentApplication> {
    @Autowired
    private EnrollmentApplicationService enrollmentApplicationService;

    protected EnrollmentApplicationController(EnrollmentApplicationService enrollmentApplicationService) {
        super(enrollmentApplicationService);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEnrollmentApplication(@RequestBody EnrollmentApplicationRequest request) {
        try {
            enrollmentApplicationService.createEnrollmentApplication(request);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel("Success", LocalDate.now().toString(), null));
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('admin', 'employee')")
    public ResponseEntity<?> updateEnrollmentApplicationById(@PathVariable("id") int id, @RequestBody EnrollmentApplicationRequest request) {
        try {
            EnrollmentApplication updatedApplication = enrollmentApplicationService.updateEnrollmentApplication(id, request);
            return ResponseUtil.success(updatedApplication);
        } catch (Exception e) {
            return ResponseUtil.error(e.getMessage());
        }
    }

    @PatchMapping("/approval")
    @PreAuthorize("hasAnyAuthority('admin', 'employee')")
    public ResponseEntity<?> approval(@RequestParam int id, @RequestParam int idStatus) {
        Object result = enrollmentApplicationService.approval(id, idStatus);
        return ResponseUtil.success(result);
    }
}
