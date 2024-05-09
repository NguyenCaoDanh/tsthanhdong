package com.thanhdong.tuyensinh.service.impl;

import com.thanhdong.tuyensinh.entity.Province;
import com.thanhdong.tuyensinh.exception.ErrorHandler;
import com.thanhdong.tuyensinh.repository.ProvinceRepository;
import com.thanhdong.tuyensinh.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;
    @Override
    public void save(Province province) {
        throw new ErrorHandler("Can not create or update.");
    }

    @Override
    public void delete(int id) {
        throw new ErrorHandler("Can not delete.");
    }

    @Override
    public List<Province> findAll() {
        try {
            return provinceRepository.findAll();
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public Province findOne(int id) {
        return provinceRepository.findById(id).orElseThrow(()-> new ErrorHandler("Can not find this province."));
    }
}
