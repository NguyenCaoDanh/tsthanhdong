package com.thanhdong.tuyensinh.service;

import com.thanhdong.tuyensinh.entity.District;
import com.thanhdong.tuyensinh.generic.IGenericService;

import java.util.List;

public interface DistrictService extends IGenericService<District> {
    List<District> districtsByProvinceId(int provinceId);
}
