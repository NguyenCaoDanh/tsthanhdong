package com.thanhdong.tuyensinh.controller;

import com.thanhdong.tuyensinh.entity.Qualification;
import com.thanhdong.tuyensinh.generic.GenericController;
import com.thanhdong.tuyensinh.generic.IGenericService;
import com.thanhdong.tuyensinh.service.QualificationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/qualifications")
public class QualificationController extends GenericController<Qualification> {
    protected QualificationController(QualificationService qualificationService) {
        super(qualificationService);
    }
}
