package com.thanhdong.tuyensinh.controller;

import com.thanhdong.tuyensinh.entity.District;
import com.thanhdong.tuyensinh.generic.GenericController;
import com.thanhdong.tuyensinh.model.response.ResponseModel;
import com.thanhdong.tuyensinh.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/districts")
public class DistrictController extends GenericController<District> {
    protected DistrictController(DistrictService dao) {
        super(dao);
    }
    @Autowired
    private DistrictService districtService;

    @GetMapping("/")
    @PreAuthorize("hasAnyAuthority('ROLE_CANDIDATE')")
    public ResponseEntity<?> getByProvinceId(@RequestParam int provinceId) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel("Success", LocalDate.now().toString(), districtService.districtsByProvinceId(provinceId)));
    }

}
