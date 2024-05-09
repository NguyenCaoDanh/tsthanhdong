package com.thanhdong.tuyensinh.controller;

import com.thanhdong.tuyensinh.entity.Province;
import com.thanhdong.tuyensinh.generic.GenericController;
import com.thanhdong.tuyensinh.generic.IGenericService;
import com.thanhdong.tuyensinh.service.ProvinceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/provinces")
public class ProvinceController extends GenericController<Province> {
    protected ProvinceController(ProvinceService dao) {
        super(dao);
    }
}
