package com.thanhdong.tuyensinh.controller;

import com.thanhdong.tuyensinh.exception.ErrorHandler;
import com.thanhdong.tuyensinh.model.request.RegistrationPreferencesRequest;
import com.thanhdong.tuyensinh.model.response.ResponseModel;
import com.thanhdong.tuyensinh.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/registration_preferences")
public class RegistrationPreferencesController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('sinhvien')")
    public ResponseEntity<?> reRegistration(@RequestBody RegistrationPreferencesRequest request) {
        try {
            if (!SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")) {
                registrationService.updateRegistrationService(SecurityContextHolder.getContext().getAuthentication().getName(), request.getRegistrationPreferencesList());
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel("Success", LocalDate.now().toString(), null));
            }
            throw new ErrorHandler("User not found !");
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }
}
