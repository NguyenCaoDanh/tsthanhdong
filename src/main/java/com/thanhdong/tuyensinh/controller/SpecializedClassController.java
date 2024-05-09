package com.thanhdong.tuyensinh.controller;

import com.thanhdong.tuyensinh.entity.SpecializedClass;
import com.thanhdong.tuyensinh.generic.GenericController;
import com.thanhdong.tuyensinh.generic.IGenericService;
import com.thanhdong.tuyensinh.service.QualificationService;
import com.thanhdong.tuyensinh.service.SpecializedClassService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/specialized-classes")
public class SpecializedClassController extends GenericController<SpecializedClass> {
    protected SpecializedClassController(SpecializedClassService specializedClassService) {
        super(specializedClassService);
    }

}
