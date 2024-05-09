package com.thanhdong.tuyensinh.service.impl;

import com.thanhdong.tuyensinh.entity.District;
import com.thanhdong.tuyensinh.exception.ErrorHandler;
import com.thanhdong.tuyensinh.repository.DistrictRepository;
import com.thanhdong.tuyensinh.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public void save(District district) {
        try {
            districtRepository.save(district);
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        throw new ErrorHandler("Not permission delete.");
    }

    @Override
    public List<District> findAll() {
        try {
            return districtRepository.findAll();
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public District findOne(int id) {
        return districtRepository.findById(id).orElseThrow(()-> new ErrorHandler("Can not find district."));
    }

    @Override
    public List<District> districtsByProvinceId(int provinceId) {
        try {
            return districtRepository.findByProvinceId(provinceId);
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }
}
